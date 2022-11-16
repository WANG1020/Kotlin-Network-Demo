package com.example.networkdemo.data.model.home

import com.google.gson.annotations.SerializedName

data class MenuListItem(
    @SerializedName("childMenuList")
    val childMenuList: List<ChildMenuList>,

    @SerializedName("iconUrl")
    val iconUrl: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,
)

data class ChildMenuList(
    @SerializedName("childIconUrl")
    val childIconUrl: String,

    @SerializedName("childId")
    val childId: String,

    @SerializedName("childName")
    val childName: String,
)