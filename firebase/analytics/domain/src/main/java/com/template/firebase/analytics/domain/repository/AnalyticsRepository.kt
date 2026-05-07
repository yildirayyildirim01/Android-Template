package com.template.firebase.analytics.domain.repository

import android.os.Bundle

interface AnalyticsRepository {
    fun logEvent(name: String, params: Bundle? = null)
    fun setUserId(userId: String?)
    fun setUserProperty(name: String, value: String?)
    fun setAnalyticsCollectionEnabled(enabled: Boolean)
}
