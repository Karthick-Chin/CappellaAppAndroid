package com.cappella.core.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import okio.IOException
import retrofit2.HttpException

fun <T> Flow<T>.asAppResponseResourceFlow(): Flow<AppResponseResource<T>> {
    return this
        .map<T, AppResponseResource<T>> {
            AppResponseResource.Success(it)
        }
        .onStart { emit(AppResponseResource.Loading(true)) }
        .onCompletion { emit(AppResponseResource.Loading(false)) }
        .catch { error ->
            val exception = when (error) {
                is HttpException -> {
                    when (error.code()) {
                        in 400..499 -> {
                            ClientException(
                                message = "${ErrorConstant.CLIENT_ERROR}: ${error.code()}",
                                cause = error,
                            )
                        }

                        in 500..599 -> {
                            ServerException(
                                message = "${ErrorConstant.SERVER_ERROR}: ${error.code()}",
                                cause = error
                            )
                        }

                        else -> {
                            UnknownException(
                                message = "${ErrorConstant.HTTP_UNKNOWN_ERROR}: ${error.code()}",
                                cause = error
                            )
                        }
                    }
                }

                is IOException -> NetworkException(
                    message = ErrorConstant.NETWORK_ERROR,
                    cause = error
                )

                else -> AppException(
                    message = ErrorConstant.UNKNOWN_ERROR,
                    cause = error
                )
            }

            val errorCode = when (error) {
                is HttpException -> {
                    when (error.code()) {
                        in 400..499 -> {
                            "#ER${error.code()}"
                        }

                        in 500..599 -> {
                            "#ER${error.code()}"
                        }

                        else -> {
                            "#ER${error.code()}"
                        }
                    }
                }

                else -> {
                    error.cause?.message.toString()
                }
            }
            emit(AppResponseResource.Error(exception, errorCode))
        }
}