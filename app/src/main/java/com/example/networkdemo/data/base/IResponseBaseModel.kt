package com.example.networkdemo.data.base

interface IResponseBaseModel {

    val elapsedTime: Int
    val errorCode: Int
    val errorDesc: String

    val logCode: String

    val serverTime: Long

    val success: Boolean
}