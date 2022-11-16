package com.example.networkdemo.data.respository

import com.example.networkdemo.api.ApiHelper

class EDPLoginRepository(private val apiHelper: ApiHelper) {
    suspend fun edpLogin() = apiHelper.edpLogin()
    suspend fun getWarehouseTypeByStoreId() = apiHelper.getWarehouseTypeByStoreId()
}