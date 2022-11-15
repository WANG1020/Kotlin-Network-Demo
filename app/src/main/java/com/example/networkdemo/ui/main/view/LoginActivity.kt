package com.example.networkdemo.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.R
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.http.NetWorkHelper
import com.example.networkdemo.ui.base.ViewModelFactory
import com.example.networkdemo.ui.main.viewmodel.MainViewModel
import com.kpa.demo.utils.Status

class LoginActivity : AppCompatActivity() {
    private val TAG: String = "LoginActivity"
    private lateinit var mainViewModel: MainViewModel
    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        val btnLogin: Button = findViewById(R.id.login)
        btnLogin.setOnClickListener{
            setupObserver()
        }
    }

    private fun setupObserver() {
        mainViewModel.login().observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {
                   Status.SUCCESS -> {
                       var intent = Intent()
                       var bundle = Bundle()
                       Log.i(TAG,resource.data.toString())
                       bundle.putString("employeeName", resource.data?.loggedInUser?.employeeName)
                       bundle.putString("employeeNo", resource.data?.loggedInUser?.employeeNo)
                       intent.putExtras(bundle)
                       intent.setClass(this,HomepageActivity::class.java)
                       startActivity(intent)
                    }
                    Status.ERROR -> {
                        Log.e(TAG,"Error")
                    }
                    Status.LOADING -> {
                        Log.i(TAG,"LOADING")
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(NetWorkHelper.apiService))).get(
            MainViewModel::class.java
        )
    }

    private fun setupUI() {
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.setOnClickListener(){
            this.finish()
        }
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.login)
    }

}