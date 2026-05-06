package com.template.firebase.auth.domain.usecase

import com.template.firebase.auth.domain.repository.AuthRepository
import javax.inject.Inject

class ObserveAuthStateUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    operator fun invoke() = authRepository.authState
}
