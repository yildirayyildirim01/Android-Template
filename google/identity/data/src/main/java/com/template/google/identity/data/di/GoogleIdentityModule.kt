package com.template.google.identity.data.di

import android.content.Context
import androidx.credentials.CredentialManager
import com.template.google.identity.data.repository.CredentialManagerGoogleIdentityRepository
import com.template.google.identity.domain.repository.GoogleIdentityRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GoogleIdentityModule {

    @Binds
    @Singleton
    abstract fun bindGoogleIdentityRepository(
        impl: CredentialManagerGoogleIdentityRepository,
    ): GoogleIdentityRepository

    companion object {
        @Provides
        @Singleton
        fun provideCredentialManager(
            @ApplicationContext context: Context,
        ): CredentialManager = CredentialManager.create(context)
    }
}
