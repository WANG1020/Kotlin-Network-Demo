package com.example.networkdemo.data.model.edplogin

import com.google.gson.annotations.SerializedName

data class ResponseGetWarehouseTypeByStoreId(
    @SerializedName("data")
    val warehouseLists: WarehouseList,

    val elapsedTime: Int,
    val errorCode: Int,
    val errorDesc: String,
    val logCode: String,
    val serverTime: Long,
    val success: Boolean
)

data class WarehouseList(
    @SerializedName("warehouseList")
    val warehouseList: List<Warehouse>,
)