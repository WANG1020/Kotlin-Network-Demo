package com.example.networkdemo.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.R
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.http.NetWorkHelper
import com.example.networkdemo.ui.base.ViewModelFactory
import com.example.networkdemo.ui.main.viewmodel.EDPLoginViewModel

import com.example.networkdemo.utils.Status

class EDPLoginActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "EDPLoginActivity"
    }

    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText

    private lateinit var edpLoginViewModel: EDPLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edplogin)
        setupUI()
        setupViewModel()
        val btnLogin: Button = findViewById(R.id.login)
        btnLogin.setOnClickListener {
            if (edtPassword.text.isNullOrEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }else{
                // setupObserver()
                var intent = Intent()
                // intent.putExtra("storeList",resource.data)
                intent.setClass(this,SelectWarehouseActivity::class.java)
                startActivity(intent)
            }
        }

        edtUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnLogin.isEnabled = true
                btnLogin.setBackgroundResource(R.drawable.i_button_red_shape)
            }

            override fun afterTextChanged(s: Editable?) {
                if(s.isNullOrEmpty()){
                    btnLogin.isEnabled = false
                    btnLogin.setBackgroundResource(R.drawable.i_button_shape)
                }
            }
        })
    }

    private fun setupObserver() {
        edpLoginViewModel.edpLogin().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        var intent = Intent()
                        // intent.putExtra("storeList",resource.data)
                        Log.i(TAG,resource.data.toString())
                        intent.setClass(this,SelectWarehouseActivity::class.java)
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
        edpLoginViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(NetWorkHelper.apiService))).get(
            EDPLoginViewModel::class.java
        )
    }


    private fun setupUI() {
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.GONE
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.edp_login)
        edtUsername = findViewById(R.id.username)
        edtPassword = findViewById(R.id.password)
    }

}