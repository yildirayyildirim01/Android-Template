/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.database.data.di

import com.google.firebase.database.FirebaseDatabase
import com.template.firebase.database.data.repository.FirebaseDatabaseRepository
import com.template.firebase.database.domain.repository.DatabaseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseDatabaseModule {

    @Binds
    @Singleton
    abstract fun bindDatabaseRepository(impl: FirebaseDatabaseRepository): DatabaseRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
    }
}
