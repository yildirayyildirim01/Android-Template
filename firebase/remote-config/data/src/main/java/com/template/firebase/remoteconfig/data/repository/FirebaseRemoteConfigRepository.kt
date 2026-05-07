package com.template.firebase.remoteconfig.data.repository

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.template.firebase.remoteconfig.domain.repository.RemoteConfigRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class FirebaseRemoteConfigRepository @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig,
) : RemoteConfigRepository {

    override suspend fun fetchAndActivate(): Boolean =
        firebaseRemoteConfig.fetchAndActivate().await()

    override suspend fun setDefaults(defaults: Map<String, Any>) {
        firebaseRemoteConfig.setDefaultsAsync(defaults).await()
    }

    override fun getString(key: String): String = firebaseRemoteConfig.getString(key)

    override fun getBoolean(key: String): Boolean = firebaseRemoteConfig.getBoolean(key)

    override fun getLong(key: String): Long = firebaseRemoteConfig.getLong(key)

    override fun getDouble(key: String): Double = firebaseRemoteConfig.getDouble(key)
}
