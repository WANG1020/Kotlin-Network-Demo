package com.example.networkdemo.data.model.home

import com.google.gson.annotations.SerializedName


data class ResponseHomepagIcon(
    @SerializedName("data")
    val menuList: MenuList,

    val elapsedTime: Int,
    val errorCode: Int,
    val errorDesc: String,
    val logCode: String,
    val serverTime: Long,
    val success: Boolean
)

data class MenuList(
    @SerializedName("menuList")
    val menuListItem: List<MenuListItem>,
)

