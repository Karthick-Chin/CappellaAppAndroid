package com.cappella.core.network

sealed interface AppResponseResource<out T> {
    data class Success<T>(val data: T) : AppResponseResource<T>
    data class Error(val exception: AppException, val errorCode: String? = null) :
        AppResponseResource<Nothing>

    data class Loading(val status: Boolean) : AppResponseResource<Nothing>
}