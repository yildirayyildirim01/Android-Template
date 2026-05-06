package com.template.google.identity.domain.model

data class GoogleSignInRequest(
    val serverClientId: String,
    val filterByAuthorizedAccounts: Boolean = true,
    val autoSelectEnabled: Boolean = true,
    val nonce: String? = null,
)
