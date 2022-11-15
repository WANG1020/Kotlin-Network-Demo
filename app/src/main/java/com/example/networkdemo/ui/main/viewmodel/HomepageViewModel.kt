package com.example.networkdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.networkdemo.data.respository.HomepageRepository
import com.kpa.demo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomepageViewModel(private val homepageRepository: HomepageRepository) : ViewModel() {
    fun logout() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d("MainViewModel","start send request")
            emit(Resource.success(homepageRepository.logout()))
            Log.d("MainViewModel","end send request")
        } catch (e: Exception) {
            Log.e("MainViewModel",e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }

    fun getHomepageInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d("MainViewModel","start send request")
            emit(Resource.success(homepageRepository.getHomepageInfo()))
            Log.d("MainViewModel","end send request")
        } catch (e: Exception) {
            Log.e("MainViewModel",e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }
}