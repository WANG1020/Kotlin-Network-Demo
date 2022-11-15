package com.example.networkdemo.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun login() = apiService.login()

    suspend fun logout() = apiService.logout()

    suspend fun getHomepageInfo() = apiService.getHomepageInfo()
}