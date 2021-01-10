package com.sample.fooddelivery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.fooddelivery.R
import com.sample.fooddelivery.adapter.CartListAdapter
import com.sample.fooddelivery.adapter.FoodListAdapter
import com.sample.fooddelivery.models.Food
import com.sample.fooddelivery.util.AppPreference
import kotlin.properties.Delegates

class CartFragment : Fragment() {

    var totalCost: Int = 0
    lateinit var appPreference: AppPreference
    var totalItems: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_cart, container, false)
        val rw_cart_list: RecyclerView = view.findViewById(R.id.rw_cart_list)
        appPreference = AppPreference(context)
        totalItems = appPreference.getIntValue("NO_OF_PRODUCTS")
        if (totalItems > 0) {
            rw_cart_list.setLayoutManager(LinearLayoutManager(context))
            val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDecorator.setDrawable(
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.recycler_divider
                )!!
            )
            rw_cart_list.addItemDecoration(itemDecorator)
            rw_cart_list.setAdapter(CartListAdapter(createDummyData(), context!!))
        }
        var tv_total_price = view.findViewById(R.id.tv_total_price) as TextView
        tv_total_price.text = "Value: " + totalCost + " USD"
        return view
    }

    private fun createDummyData(): MutableList<Food> {
        var dummyFoodList: MutableList<Food> = mutableListOf()
        for (i in 1..totalItems) {
            var food: Food = Food()
            food.foodName = "Pizza"
            food.foodContent = "mozerela"
            food.sizeDetails = "78 gram"
            food.price = "67"
            dummyFoodList.add(food)
            totalCost += Integer.parseInt(food.price)
        }
        return dummyFoodList
    }

}