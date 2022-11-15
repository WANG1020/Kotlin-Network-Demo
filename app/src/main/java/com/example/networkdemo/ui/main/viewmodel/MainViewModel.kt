package com.example.networkdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.networkdemo.data.respository.LoginRepository
import com.kpa.demo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun login() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d("MainViewModel","start send request")
            emit(Resource.success(loginRepository.login()))
            Log.d("MainViewModel","end send request")
        } catch (e: Exception) {
            Log.e("MainViewModel",e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }
}