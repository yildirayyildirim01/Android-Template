package com.template.google.identity.data.repository

import android.content.Context
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.template.google.identity.domain.model.GoogleIdToken
import com.template.google.identity.domain.model.GoogleSignInRequest
import com.template.google.identity.domain.repository.GoogleIdentityRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CredentialManagerGoogleIdentityRepository @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val credentialManager: CredentialManager,
) : GoogleIdentityRepository {

    override suspend fun getGoogleIdToken(request: GoogleSignInRequest): GoogleIdToken {
        val googleIdOption = GetGoogleIdOption.Builder()
            .setServerClientId(request.serverClientId)
            .setFilterByAuthorizedAccounts(request.filterByAuthorizedAccounts)
            .setAutoSelectEnabled(request.autoSelectEnabled)
            .apply {
                request.nonce?.let(::setNonce)
            }
            .build()

        val credentialRequest = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        val credential = credentialManager.getCredential(
            context = context,
            request = credentialRequest,
        ).credential

        if (
            credential !is CustomCredential ||
            credential.type != TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ) {
            throw IllegalStateException("Credential is not a Google ID token credential.")
        }

        return try {
            GoogleIdToken(
                value = GoogleIdTokenCredential.createFrom(credential.data).idToken,
            )
        } catch (exception: GoogleIdTokenParsingException) {
            throw IllegalStateException("Google ID token could not be parsed.", exception)
        }
    }

    override suspend fun clearCredentialState() {
        credentialManager.clearCredentialState(ClearCredentialStateRequest())
    }
}
