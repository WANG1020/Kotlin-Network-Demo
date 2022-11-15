package com.example.networkdemo.data.http

import com.example.networkdemo.http.interceptor.HttpLoggingInterceptor
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceCreator {
    private val okHttpClient by lazy { OkHttpClient().newBuilder() }
    private val retrofit: Retrofit by lazy {
        val builder = Retrofit.Builder()
            .baseUrl("https://blog.csdn.net/")
            .addConverterFactory(GsonConverterFactory.create())
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        okHttpClient
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor())
            .dispatcher(dispatcher)
        builder.client(okHttpClient.build()).build()
    }

    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)

    inline fun <reified T> createService(clazz: Class<T>): T =
        create(clazz)

}