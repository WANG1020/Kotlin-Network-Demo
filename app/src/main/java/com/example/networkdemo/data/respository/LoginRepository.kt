package com.example.networkdemo.data.respository

import com.example.networkdemo.api.ApiHelper

class LoginRepository(private val apiHelper: ApiHelper) {
    suspend fun login() = apiHelper.login()
}