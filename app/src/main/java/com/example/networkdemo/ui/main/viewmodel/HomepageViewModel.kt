package com.example.networkdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.networkdemo.data.respository.HomepageRepository
import com.example.networkdemo.ui.main.view.HomepageActivity
import com.example.networkdemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomepageViewModel(private val homepageRepository: HomepageRepository) : ViewModel() {
    fun logout() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d(HomepageActivity.TAG,"start send request")
            emit(Resource.success(homepageRepository.logout()))
            Log.d(HomepageActivity.TAG,"end send request")
        } catch (e: Exception) {
            Log.e(HomepageActivity.TAG, e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }

    fun getHomepageInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d(HomepageActivity.TAG,"start send request")
            emit(Resource.success(homepageRepository.getHomepageInfo()))
            Log.d(HomepageActivity.TAG,"end send request")
        } catch (e: Exception) {
            Log.e(HomepageActivity.TAG, e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }
}