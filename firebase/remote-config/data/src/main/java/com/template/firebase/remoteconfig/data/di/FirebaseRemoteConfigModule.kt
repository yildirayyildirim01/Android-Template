package com.template.firebase.remoteconfig.data.di

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.template.firebase.remoteconfig.data.repository.FirebaseRemoteConfigRepository
import com.template.firebase.remoteconfig.domain.repository.RemoteConfigRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseRemoteConfigModule {

    @Binds
    @Singleton
    abstract fun bindRemoteConfigRepository(impl: FirebaseRemoteConfigRepository): RemoteConfigRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseRemoteConfig(): FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    }
}
