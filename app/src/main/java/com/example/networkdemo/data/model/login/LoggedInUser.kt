package com.example.networkdemo.data.model.login

import com.google.gson.annotations.SerializedName

data class LoggedInUser(
    @SerializedName("employeeName")
    val employeeName: String,

    @SerializedName("employeeNo")
    val employeeNo: String,

    @SerializedName("mobile")
    val mobile: String,

    @SerializedName("sectionName")
    val sectionName: String,

    @SerializedName("sectionNo")
    val sectionNo: String,

    @SerializedName("sectionNoList")
    val sectionNoList: String,
)