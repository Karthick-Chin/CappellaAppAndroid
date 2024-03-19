package com.cappella.login.data.repository

import com.cappella.login.data.service.LoginService
import com.cappella.login.domain.model.LoginRequest
import com.cappella.login.domain.model.LoginResponse
import com.cappella.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
): LoginRepository {

    override fun doLogin(loginRequest: LoginRequest): Flow<LoginResponse> {
        return flow {
            emit(loginService.login(loginRequest))
        }
    }
}