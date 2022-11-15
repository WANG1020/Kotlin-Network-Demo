package com.example.networkdemo.data.model.login

import com.google.gson.annotations.SerializedName

data class ResponseLogout(
    @SerializedName("data")
    val data: Nothing? = null,

    val elapsedTime: Int,
    val errorCode: Int,
    val errorDesc: String,
    val logCode: String,
    val serverTime: Long,
    val success: Boolean
)