package com.example.networkdemo.api

import com.example.networkdemo.data.model.edplogin.ResponseEDPLogin
import com.example.networkdemo.data.model.edplogin.ResponseGetWarehouseTypeByStoreId
import com.example.networkdemo.data.model.login.ResponseLoggedInUser
import com.example.networkdemo.data.model.login.ResponseLogout
import com.example.networkdemo.data.model.home.ResponseHomepagIcon
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/nav/python")
    suspend fun login(): ResponseLoggedInUser

    @GET("nav/java")
    suspend fun logout(): ResponseLogout

    @POST("nav/lang")
    suspend fun getHomepageInfo(): ResponseHomepagIcon

    @POST("/nav/web")
    suspend fun edpLogin(): ResponseEDPLogin

    @POST("/nav/back-end")
    suspend fun getWarehouseTypeByStoreId(): ResponseGetWarehouseTypeByStoreId
}