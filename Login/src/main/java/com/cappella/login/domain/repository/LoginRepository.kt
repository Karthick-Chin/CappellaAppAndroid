package com.cappella.login.domain.repository

import com.cappella.login.domain.model.LoginRequest
import com.cappella.login.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun doLogin(loginRequest: LoginRequest): Flow<LoginResponse>
}