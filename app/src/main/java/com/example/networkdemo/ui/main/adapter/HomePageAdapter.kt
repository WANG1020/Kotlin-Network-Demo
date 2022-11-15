package com.example.networkdemo.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networkdemo.R
import com.example.networkdemo.data.model.home.MenuListItem

class HomePageAdapter(private val menuListItems: ArrayList<MenuListItem>) :
    RecyclerView.Adapter<HomePageAdapter.DataViewHolder>() {

    var itemClickListener: ListItemClickListener? = null

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.ivIcon)
        val iconName: TextView = itemView.findViewById(R.id.tvIconName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_homepage, parent, false)
        )


    override fun getItemCount() = menuListItems.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val menuListItem = menuListItems[position]
        with(holder) {
            Glide.with(icon.context).load(menuListItem.iconUrl).into(icon)
            iconName.text = menuListItem.name
        }
        holder.icon.setOnClickListener {
            itemClickListener?.invoke(position)
        }
    }

    fun addData(menuListItems: List<MenuListItem>) {
        this.menuListItems.addAll(menuListItems)
    }

}
typealias ListItemClickListener = (Int) -> Unit // 设置Item控件点击事件