/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.messaging.data.di

import com.google.firebase.messaging.FirebaseMessaging
import com.template.firebase.messaging.data.repository.FirebaseMessagingRepository
import com.template.firebase.messaging.domain.repository.MessagingRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseMessagingModule {

    @Binds
    @Singleton
    abstract fun bindMessagingRepository(impl: FirebaseMessagingRepository): MessagingRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()
    }
}
