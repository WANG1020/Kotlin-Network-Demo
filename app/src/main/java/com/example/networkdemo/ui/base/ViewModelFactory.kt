package com.example.networkdemo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.respository.HomepageRepository
import com.example.networkdemo.ui.main.viewmodel.MainViewModel
import com.example.networkdemo.data.respository.LoginRepository
import com.example.networkdemo.ui.main.viewmodel.HomepageViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                LoginRepository(apiHelper)
            ) as T
        }
        if (modelClass.isAssignableFrom(HomepageViewModel::class.java)) {
            return HomepageViewModel(
                HomepageRepository(apiHelper)
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}