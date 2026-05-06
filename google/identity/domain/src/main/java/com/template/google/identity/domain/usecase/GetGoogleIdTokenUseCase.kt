package com.template.google.identity.domain.usecase

import com.template.google.identity.domain.model.GoogleSignInRequest
import com.template.google.identity.domain.repository.GoogleIdentityRepository
import javax.inject.Inject

class GetGoogleIdTokenUseCase @Inject constructor(
    private val googleIdentityRepository: GoogleIdentityRepository,
) {
    suspend operator fun invoke(request: GoogleSignInRequest) =
        googleIdentityRepository.getGoogleIdToken(request)
}
