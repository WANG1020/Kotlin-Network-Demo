package com.example.networkdemo.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.R
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.http.NetWorkHelper
import com.example.networkdemo.ui.base.ViewModelFactory
import com.example.networkdemo.ui.main.viewmodel.EDPLoginViewModel
import com.example.networkdemo.utils.Status

class SelectWarehouseActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "SelectWarehouseActivity"
    }

    private lateinit var lvTop: LinearLayout
    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView
    private lateinit var btSubmit: Button

    private lateinit var edpLoginViewModel: EDPLoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_warehouse)
        setupUI()
        setupViewModel()
        // getWarehouseTypeByStoreId()
    }

    private fun getWarehouseTypeByStoreId() {
        edpLoginViewModel.getWarehouseTypeByStoreId().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        var intent = Intent()
                        // intent.putExtra("storeList",resource.data)
                        Log.i(EDPLoginActivity.TAG,resource.data.toString())
                        intent.setClass(this,SelectWarehouseActivity::class.java)
                        startActivity(intent)
                    }
                    Status.ERROR -> {
                        Log.e(EDPLoginActivity.TAG,"Error")
                    }
                    Status.LOADING -> {
                        Log.i(EDPLoginActivity.TAG,"LOADING")
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        edpLoginViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(NetWorkHelper.apiService))).get(
            EDPLoginViewModel::class.java
        )
    }

    private fun setupUI() {
        lvTop = findViewById(R.id.lvTop)
        lvTop.visibility = View.GONE
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.setOnClickListener(){
            this.finish()
        }
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.select_store)
        btSubmit = findViewById(R.id.btSubmit)
        btSubmit.setOnClickListener() {
            var intent = Intent()
            intent.setClass(this,LoginActivity ::class.java)
            startActivity(intent)
        }
    }
}