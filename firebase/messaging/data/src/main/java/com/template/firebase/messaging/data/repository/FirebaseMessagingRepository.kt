package com.template.firebase.messaging.data.repository

import com.google.firebase.messaging.FirebaseMessaging
import com.template.firebase.messaging.domain.repository.MessagingRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class FirebaseMessagingRepository @Inject constructor(
    private val firebaseMessaging: FirebaseMessaging,
) : MessagingRepository {

    override suspend fun getToken(): String = firebaseMessaging.token.await()

    override suspend fun deleteToken() {
        firebaseMessaging.deleteToken().await()
    }

    override suspend fun subscribeToTopic(topic: String) {
        firebaseMessaging.subscribeToTopic(topic).await()
    }

    override suspend fun unsubscribeFromTopic(topic: String) {
        firebaseMessaging.unsubscribeFromTopic(topic).await()
    }

    override fun setAutoInitEnabled(enabled: Boolean) {
        firebaseMessaging.isAutoInitEnabled = enabled
    }
}
