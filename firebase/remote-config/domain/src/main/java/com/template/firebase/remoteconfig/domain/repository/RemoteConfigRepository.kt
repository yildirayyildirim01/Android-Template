package com.template.firebase.remoteconfig.domain.repository

interface RemoteConfigRepository {
    suspend fun fetchAndActivate(): Boolean
    suspend fun setDefaults(defaults: Map<String, Any>)
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
    fun getLong(key: String): Long
    fun getDouble(key: String): Double
}
