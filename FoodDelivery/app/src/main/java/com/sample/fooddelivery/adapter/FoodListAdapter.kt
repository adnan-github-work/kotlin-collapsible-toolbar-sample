package com.sample.fooddelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.fooddelivery.R
import com.sample.fooddelivery.models.Food
import com.sample.fooddelivery.util.AppPreference


class FoodListAdapter(
    private val itemsData: MutableList<Food>,
    val context: Context
) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>(), View.OnClickListener {

    var appPreference : AppPreference = AppPreference(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_food_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        position: Int
    ) {
        val food = itemsData[position]
        viewHolder.tv_food_name.text = food.foodName
        viewHolder.tv_food_content.text = food.foodContent
        viewHolder.tv_size_details.text = food.sizeDetails
        viewHolder.bt_add_to_cart.text = food.price + " USD"
        viewHolder.view.tag = food
        viewHolder.bt_add_to_cart.setOnClickListener(this)
        viewHolder.bt_add_to_cart.tag = food

    }

    override fun getItemCount(): Int {
        return itemsData.size
    }

    override fun onClick(view: View) {
        val food = view.tag as Food
        var button = view as Button
        button.background = context.resources.getDrawable(R.drawable.round_button_green)
        button.text = "added + 1"
        button.isAllCaps = false
        appPreference.savePreferences("NO_OF_PRODUCTS", appPreference.getIntValue("NO_OF_PRODUCTS") + 1)
        var v = view.parent.parent.parent.parent.parent.parent.parent as View
        var text = v.findViewById(R.id.tv_fab) as TextView
        text.visibility = View.VISIBLE
        text.text = appPreference.getIntValue("NO_OF_PRODUCTS").toString()

    }

    class ViewHolder(var view: View) :
        RecyclerView.ViewHolder(view) {
        var tv_food_name: TextView
        var tv_food_content: TextView
        var tv_size_details: TextView
        var bt_add_to_cart: Button

        init {
            tv_food_name =
                view.findViewById<View>(R.id.tv_food_name) as TextView
            tv_size_details =
                view.findViewById<View>(R.id.tv_size_details) as TextView
            tv_food_content =
                view.findViewById<View>(R.id.tv_food_content) as TextView
            bt_add_to_cart =
                view.findViewById<View>(R.id.bt_add_to_cart) as Button
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}