package com.cappella.login.data.service

import com.cappella.login.domain.model.LoginRequest
import com.cappella.login.domain.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/api/auth/login/")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}