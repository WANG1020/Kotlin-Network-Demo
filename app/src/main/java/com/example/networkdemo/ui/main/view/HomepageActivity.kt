package com.example.networkdemo.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkdemo.R
import com.example.networkdemo.api.ApiHelper
import com.example.networkdemo.data.http.NetWorkHelper
import com.example.networkdemo.data.model.home.MenuList
import com.example.networkdemo.ui.base.ViewModelFactory
import com.example.networkdemo.ui.main.adapter.HomePageAdapter
import com.example.networkdemo.ui.main.viewmodel.HomepageViewModel
import com.example.networkdemo.utils.Status

class HomepageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "HomepageActivity"
    }
    private lateinit var homepageViewModel: HomepageViewModel
    private lateinit var adapter: HomePageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvLogout: TextView
    private lateinit var tvIdentity: TextView
    private lateinit var ibReturn: ImageButton
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        setupUI()
        setupViewModel()
        setupHomepageObserver()
        val tvLogout: TextView = findViewById(R.id.tvLogout)
        tvLogout.setOnClickListener(){
            setupLogoutObserver()
        }
    }


    private fun setupLogoutObserver() {
        homepageViewModel.logout().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        this.finish()
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

    private fun setupHomepageObserver() {
        homepageViewModel.getHomepageInfo().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        resource.data?.let { it1 -> renderList(it1.menuList) }
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

    private fun renderList(menuListItems: MenuList) {
        adapter.apply {
            addData(menuListItems.menuListItem)
            notifyDataSetChanged()
        }
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.tvHomepageIcons)
        tvIdentity = findViewById(R.id.tvIdentity)
        tvLogout = findViewById(R.id.tvLogout)
        ibReturn = findViewById(R.id.ibReturn)
        tvLogout.visibility = View.VISIBLE
        tvIdentity.visibility = View.VISIBLE
        ibReturn.setOnClickListener(){
            this.finish()
        }
        val bundle = this.intent.extras
        if (bundle != null) {
            tvIdentity.text = bundle.getString("employeeName") +
                    "（" + bundle.getString("employeeNo")+"）"
            Log.e(TAG,"This is response")
        }

        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.setText(R.string.homepage)
        val gridLayoutManager= GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false)
        gridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
            }
        }
        recyclerView.layoutManager = gridLayoutManager
        adapter = HomePageAdapter(arrayListOf())
        adapter.itemClickListener = {
            Toast.makeText(this, "你点${it}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        homepageViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(NetWorkHelper.apiService))).get(
            HomepageViewModel::class.java
        )
    }
}