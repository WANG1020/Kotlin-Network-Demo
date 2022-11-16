package com.example.networkdemo.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.networkdemo.data.respository.EDPLoginRepository
import com.example.networkdemo.ui.main.view.EDPLoginActivity
import com.example.networkdemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class EDPLoginViewModel(private val edpLoginRepository: EDPLoginRepository) : ViewModel() {
    fun edpLogin() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d(EDPLoginActivity.TAG,"start send request")
            emit(Resource.success(edpLoginRepository.edpLogin()))
            Log.d(EDPLoginActivity.TAG,"end send request")
        } catch (e: Exception) {
            Log.e(EDPLoginActivity.TAG, e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }

    fun getWarehouseTypeByStoreId() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            Log.d(EDPLoginActivity.TAG,"start send request")
            emit(Resource.success(edpLoginRepository.getWarehouseTypeByStoreId()))
            Log.d(EDPLoginActivity.TAG,"end send request")
        } catch (e: Exception) {
            Log.e(EDPLoginActivity.TAG, e.message.toString())
            emit(Resource.error(e.message, null))
        }
    }
}