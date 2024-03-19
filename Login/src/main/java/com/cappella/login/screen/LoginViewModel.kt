package com.cappella.login.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cappella.core.network.AppResponseResource
import com.cappella.core.network.asAppResponseResourceFlow
import com.cappella.login.domain.model.LoginRequest
import com.cappella.login.domain.model.LoginResponse
import com.cappella.login.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginState = MutableSharedFlow<AppResponseResource<LoginResponse>>()
    val loginState = _loginState.asSharedFlow()

    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            loginUseCase.invoke(
                LoginRequest(
                    email = email,
                    password = password,
                    device_id = "device_id_parent1"
                )
            ).asAppResponseResourceFlow()
                .onEach {
                    _loginState.emit(it)
                }
                .collect()
        }
    }
}