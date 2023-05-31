package com.hmn.buildconfig.viewholder

import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hmn.shared.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.view_holder_restaurant.view.*

class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(data: RestaurantVO) {
        Glide.with(itemView.context)
            .load(data.imageUrl)
            .into(itemView.ivRestaurantImage)

        itemView.tvRestaurantName.text = data.name
        itemView.tvRestaurantCategory.text = data.category
        itemView.tvDeliveryPrice.text = "${data.deliveryPrice.toString()} MMK"
        itemView.tvRating.text = data.rating.toString()

    }
}