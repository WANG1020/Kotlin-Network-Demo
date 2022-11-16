package com.example.networkdemo.data.model.edplogin

import com.google.gson.annotations.SerializedName

data class StoreListAndToken(

    @SerializedName("storeList")
    val storeList: List<Store>,

    @SerializedName("token")
    val token: String

)