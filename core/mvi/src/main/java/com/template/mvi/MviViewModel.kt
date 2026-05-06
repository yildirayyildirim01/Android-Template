package com.template.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class MviViewModel<Intent : MviIntent, State : MviState, Effect : MviEffect>(
    initialState: State,
    effectBufferCapacity: Int = DEFAULT_EFFECT_BUFFER_CAPACITY,
) : ViewModel(), MviContainer<Intent, State, Effect> {

    private val mutableState = MutableStateFlow(initialState)
    override val state: StateFlow<State> = mutableState.asStateFlow()

    private val mutableEffect = MutableSharedFlow<Effect>(
        replay = 0,
        extraBufferCapacity = effectBufferCapacity,
    )
    override val effect: SharedFlow<Effect> = mutableEffect.asSharedFlow()

    private val intents: Channel<Intent> = Channel(Channel.UNLIMITED)

    init {
        viewModelScope.launch {
            intents.consumeAsFlow().collect { intent ->
                handleIntent(intent)
            }
        }
    }

    protected val currentState: State
        get() = mutableState.value

    final override fun onIntent(intent: Intent) {
        intents.trySend(intent)
    }

    protected abstract suspend fun handleIntent(intent: Intent)

    protected fun reduce(reducer: State.() -> State) {
        mutableState.update { state -> state.reducer() }
    }

    protected suspend fun sendEffect(effect: Effect) {
        mutableEffect.emit(effect)
    }

    protected fun sendEffectNow(effect: Effect): Boolean = mutableEffect.tryEmit(effect)

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit,
    ): Job = viewModelScope.launch(context = context, block = block)

    override fun onCleared() {
        intents.close()
        super.onCleared()
    }

    private companion object {
        const val DEFAULT_EFFECT_BUFFER_CAPACITY = 64
    }
}
