package com.hmn.buildconfig.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hmn.buildconfig.R
import com.hmn.buildconfig.viewholder.RestaurantViewHolder
import com.hmn.shared.data.vos.RestaurantVO

open class RestaurantAdapter : RecyclerView.Adapter<RestaurantViewHolder>() {
    private var mData: List<RestaurantVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        if (mData.isNotEmpty()) {
            holder.bindData(mData[position])
        }
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    fun setNewData(restaurant: List<RestaurantVO>) {
        mData = restaurant
        notifyDataSetChanged()
    }
}