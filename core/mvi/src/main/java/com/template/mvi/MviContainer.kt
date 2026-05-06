package com.template.mvi

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MviContainer<Intent : MviIntent, State : MviState, Effect : MviEffect> {
    val state: StateFlow<State>
    val effect: SharedFlow<Effect>

    fun onIntent(intent: Intent)
}
