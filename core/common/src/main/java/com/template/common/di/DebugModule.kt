/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.common.di

import com.template.common.BuildConfig
import com.template.common.qualifier.IsDebug
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DebugModule {

    @Provides
    @IsDebug
    fun provideIsDebug(): Boolean = BuildConfig.DEBUG
}
