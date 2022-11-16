package com.example.networkdemo.data.model.login

import com.google.gson.annotations.SerializedName

class ResponseLoggedInUser(
    @SerializedName("data")
    val loggedInUser: LoggedInUser,

    val elapsedTime: Int,
    val errorCode: Int,
    val errorDesc: String,
    val logCode: String,
    val serverTime: Long,
    val success: Boolean
)