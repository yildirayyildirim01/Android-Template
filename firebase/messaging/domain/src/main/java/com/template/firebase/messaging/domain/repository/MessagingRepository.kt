package com.template.firebase.messaging.domain.repository

interface MessagingRepository {
    suspend fun getToken(): String
    suspend fun deleteToken()
    suspend fun subscribeToTopic(topic: String)
    suspend fun unsubscribeFromTopic(topic: String)
    fun setAutoInitEnabled(enabled: Boolean)
}
