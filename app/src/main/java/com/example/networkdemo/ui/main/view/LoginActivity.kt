package com.example.networkdemo.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networkdemo.R
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.http.NetWorkHelper
import com.example.networkdemo.ui.base.ViewModelFactory
import com.example.networkdemo.ui.main.viewmodel.LoginViewModel
import com.example.networkdemo.utils.Status

class LoginActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "LoginActivity"
    }
    private lateinit var mainViewModel: LoginViewModel
    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        val btnLogin: Button = findViewById(R.id.login)
        btnLogin.setOnClickListener{
            if (edtPassword.text.isNullOrEmpty()) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }else{
                setupObserver()
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
            LoginViewModel::class.java
        )
    }

    private fun setupUI() {
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.setOnClickListener(){
            this.finish()
        }
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.login)
        edtUsername = findViewById(R.id.username)
        edtPassword = findViewById(R.id.password)
    }

}