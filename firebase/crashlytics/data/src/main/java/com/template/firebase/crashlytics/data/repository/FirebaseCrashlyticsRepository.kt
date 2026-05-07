package com.template.firebase.crashlytics.data.repository

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.template.firebase.crashlytics.domain.repository.CrashlyticsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseCrashlyticsRepository @Inject constructor(
    private val firebaseCrashlytics: FirebaseCrashlytics,
) : CrashlyticsRepository {

    override fun log(message: String) {
        firebaseCrashlytics.log(message)
    }

    override fun recordException(throwable: Throwable) {
        firebaseCrashlytics.recordException(throwable)
    }

    override fun setUserId(userId: String) {
        firebaseCrashlytics.setUserId(userId)
    }

    override fun setCustomKey(key: String, value: String) {
        firebaseCrashlytics.setCustomKey(key, value)
    }

    override fun setCustomKey(key: String, value: Boolean) {
        firebaseCrashlytics.setCustomKey(key, value)
    }

    override fun setCustomKey(key: String, value: Int) {
        firebaseCrashlytics.setCustomKey(key, value)
    }

    override fun setCustomKey(key: String, value: Long) {
        firebaseCrashlytics.setCustomKey(key, value)
    }

    override fun setCustomKey(key: String, value: Double) {
        firebaseCrashlytics.setCustomKey(key, value)
    }

    override fun setCrashlyticsCollectionEnabled(enabled: Boolean) {
        firebaseCrashlytics.setCrashlyticsCollectionEnabled(enabled)
    }
}
