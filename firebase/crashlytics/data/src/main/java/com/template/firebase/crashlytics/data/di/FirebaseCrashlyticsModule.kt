package com.template.firebase.crashlytics.data.di

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.template.firebase.crashlytics.data.repository.FirebaseCrashlyticsRepository
import com.template.firebase.crashlytics.domain.repository.CrashlyticsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseCrashlyticsModule {

    @Binds
    @Singleton
    abstract fun bindCrashlyticsRepository(impl: FirebaseCrashlyticsRepository): CrashlyticsRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseCrashlytics(): FirebaseCrashlytics = FirebaseCrashlytics.getInstance()
    }
}
