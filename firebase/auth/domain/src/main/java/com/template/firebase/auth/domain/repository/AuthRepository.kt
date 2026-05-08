/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.firebase.auth.domain.repository

import com.template.firebase.auth.domain.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: AuthUser?
    val authState: Flow<AuthUser?>

    suspend fun signInWithGoogleIdToken(idToken: String): AuthUser
    suspend fun signOut()
}
