package com.cappella.login.domain.usecase

import com.cappella.login.domain.model.LoginRequest
import com.cappella.login.domain.model.LoginResponse
import com.cappella.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    fun invoke(loginRequest: LoginRequest): Flow<LoginResponse> {
        return loginRepository.doLogin(loginRequest)
    }
}