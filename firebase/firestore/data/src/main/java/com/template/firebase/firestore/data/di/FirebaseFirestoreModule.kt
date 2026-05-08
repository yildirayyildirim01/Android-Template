/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.firestore.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.template.firebase.firestore.data.repository.FirebaseFirestoreRepository
import com.template.firebase.firestore.domain.repository.FirestoreRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseFirestoreModule {

    @Binds
    @Singleton
    abstract fun bindFirestoreRepository(impl: FirebaseFirestoreRepository): FirestoreRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()
    }
}
