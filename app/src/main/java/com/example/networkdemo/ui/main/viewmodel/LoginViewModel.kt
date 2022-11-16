package com.example.networkdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.networkdemo.data.respository.LoginRepository
import com.example.networkdemo.ui.main.view.LoginActivity
import com.example.networkdemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun login() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d(LoginActivity.TAG,"start send request")
            emit(Resource.success(loginRepository.login()))
            Log.d(LoginActivity.TAG,"end send request")
        } catch (e: Exception) {
            Log.e(LoginActivity.TAG, e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }
}