package com.example.networkdemo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.respository.EDPLoginRepository
import com.example.networkdemo.data.respository.HomepageRepository
import com.example.networkdemo.ui.main.viewmodel.LoginViewModel
import com.example.networkdemo.data.respository.LoginRepository
import com.example.networkdemo.ui.main.viewmodel.EDPLoginViewModel
import com.example.networkdemo.ui.main.viewmodel.HomepageViewModel


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                LoginRepository(apiHelper)
            ) as T
        }
        if (modelClass.isAssignableFrom(HomepageViewModel::class.java)) {
            return HomepageViewModel(
                HomepageRepository(apiHelper)
            ) as T
        }
        if (modelClass.isAssignableFrom(EDPLoginViewModel::class.java)) {
            return EDPLoginViewModel(
                EDPLoginRepository(apiHelper)
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}