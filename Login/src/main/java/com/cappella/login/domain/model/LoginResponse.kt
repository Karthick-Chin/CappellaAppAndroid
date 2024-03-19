package com.cappella.login.domain.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access")
    val access: String,
    @SerializedName("refresh")
    val refresh: String,
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("user")
    val user: User
) {
    data class User(
        @SerializedName("pk")
        val pk: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("first_name")
        val first_name: String,
        @SerializedName("last_name")
        val last_name: String,
        @SerializedName("is_subscribed")
        val is_subscribed: Boolean
    )
}
