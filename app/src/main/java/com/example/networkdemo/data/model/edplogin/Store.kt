package com.example.networkdemo.data.model.edplogin

import com.google.gson.annotations.SerializedName

data class Store(

    @SerializedName("storeId")
    val storeId: String,

    @SerializedName("storeName")
    val storeName: String
)



