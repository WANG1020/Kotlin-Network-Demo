package com.example.networkdemo.data.model.edplogin

import com.google.gson.annotations.SerializedName

data class ResponseEDPLogin(
    @SerializedName("data")
    val storeList: StoreListAndToken,

    val elapsedTime: Int,
    val errorCode: Int,
    val errorDesc: String,
    val logCode: String,
    val serverTime: Long,
    val success: Boolean
)

