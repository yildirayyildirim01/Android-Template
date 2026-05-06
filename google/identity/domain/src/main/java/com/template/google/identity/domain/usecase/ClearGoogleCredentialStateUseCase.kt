package com.template.google.identity.domain.usecase

import com.template.google.identity.domain.repository.GoogleIdentityRepository
import javax.inject.Inject

class ClearGoogleCredentialStateUseCase @Inject constructor(
    private val googleIdentityRepository: GoogleIdentityRepository,
) {
    suspend operator fun invoke() = googleIdentityRepository.clearCredentialState()
}
