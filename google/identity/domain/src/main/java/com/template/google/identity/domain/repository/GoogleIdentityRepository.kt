package com.template.google.identity.domain.repository

import com.template.google.identity.domain.model.GoogleIdToken
import com.template.google.identity.domain.model.GoogleSignInRequest

interface GoogleIdentityRepository {
    suspend fun getGoogleIdToken(request: GoogleSignInRequest): GoogleIdToken
    suspend fun clearCredentialState()
}
