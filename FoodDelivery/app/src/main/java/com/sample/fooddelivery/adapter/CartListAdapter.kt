package com.sample.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.fooddelivery.R
import com.sample.fooddelivery.models.Food

class CartListAdapter(
    private val itemsData: MutableList<Food>,
    val context: Context
) :
    RecyclerView.Adapter<CartListAdapter.ViewHolder>(), View.OnClickListener {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_cart_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val food = itemsData[position]
        viewHolder.tv_food_name.text = food.foodName
        viewHolder.tv_price.text = food.price + " USD"
        viewHolder.im_remove.setOnClickListener(this)
        viewHolder.view.tag = food
        viewHolder.view.setOnClickListener(this)
    }

    override fun getItemCount(): Int {
        return itemsData.size
    }

    override fun onClick(view: View) {
        val food = view.tag as Food
        /*Intent viewContentIntent = new Intent(context.getApplicationContext(), Map.class);
        viewContentIntent.putExtra("newsURL", food.getCreatedAt());
        context.startActivity(viewContentIntent);*/
    }

    class ViewHolder(var view: View) :
        RecyclerView.ViewHolder(view) {
        var tv_food_name: TextView
        var tv_price: TextView
        var im_remove: ImageView

        init {
            tv_food_name =
                view.findViewById<View>(R.id.tv_food_name) as TextView
            tv_price =
                view.findViewById<View>(R.id.tv_price) as TextView
            im_remove =
                view.findViewById<View>(R.id.im_remove) as ImageView
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}