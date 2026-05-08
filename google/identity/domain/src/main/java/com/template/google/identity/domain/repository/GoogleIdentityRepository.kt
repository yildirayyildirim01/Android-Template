/*
 * Copyright 2026 Android Template
 *
 * Licensed under the Apache License, Version 2.0.
 */
package com.template.google.identity.domain.repository

import com.template.google.identity.domain.model.GoogleIdToken
import com.template.google.identity.domain.model.GoogleSignInRequest

interface GoogleIdentityRepository {
    suspend fun getGoogleIdToken(request: GoogleSignInRequest): GoogleIdToken
    suspend fun clearCredentialState()
}
