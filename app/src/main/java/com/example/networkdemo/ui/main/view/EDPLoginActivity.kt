package com.example.networkdemo.ui.main.view

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.networkdemo.R

class EDPLoginActivity : AppCompatActivity() {
    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edplogin)
        setupUI()
        val btLogin: Button = findViewById(R.id.login)
        btLogin.setOnClickListener() {
            var intent = Intent()
            intent.setClass(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupUI() {
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.GONE
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.edp_login)
    }

}