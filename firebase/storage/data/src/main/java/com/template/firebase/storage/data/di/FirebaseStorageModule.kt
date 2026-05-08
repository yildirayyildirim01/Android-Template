/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.storage.data.di

import com.google.firebase.storage.FirebaseStorage
import com.template.firebase.storage.data.repository.FirebaseStorageRepository
import com.template.firebase.storage.domain.repository.StorageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseStorageModule {

    @Binds
    @Singleton
    abstract fun bindStorageRepository(impl: FirebaseStorageRepository): StorageRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()
    }
}
