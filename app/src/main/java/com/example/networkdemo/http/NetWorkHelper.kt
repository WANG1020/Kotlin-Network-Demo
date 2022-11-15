package com.example.networkdemo.data.http

import com.example.networkdemo.api.ApiService


object NetWorkHelper {
    val apiService =
        ServiceCreator.createService(ApiService::class.java)
}