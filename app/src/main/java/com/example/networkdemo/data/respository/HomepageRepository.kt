package com.example.networkdemo.data.respository

import com.example.networkdemo.api.ApiHelper

class HomepageRepository(private val apiHelper: ApiHelper)  {
    suspend fun logout() = apiHelper.logout()
    suspend fun getHomepageInfo() = apiHelper.getHomepageInfo()
}