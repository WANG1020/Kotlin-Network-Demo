package com.example.networkdemo.data.model.edplogin

import com.google.gson.annotations.SerializedName

data class Warehouse(

    @SerializedName("useType")
    val useType: Int,

    @SerializedName("warehouseName")
    val warehouseName: String,

    @SerializedName("warehouseNo")
    val warehouseNo: String
)
