package com.sample.fooddelivery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.fooddelivery.R
import com.sample.fooddelivery.adapter.FoodListAdapter
import com.sample.fooddelivery.models.Food
import com.sample.fooddelivery.util.AppPreference

class FoodFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_food, container, false)
        val rw_food_list: RecyclerView = view.findViewById(R.id.rw_food_list)
        rw_food_list.setLayoutManager(LinearLayoutManager(context))
        var appPreference : AppPreference = AppPreference(context)
        appPreference.savePreferences("NO_OF_PRODUCTS", 0)
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(context!!, R.drawable.recycler_divider)!!)
        rw_food_list.addItemDecoration(itemDecorator)
        rw_food_list.setAdapter(FoodListAdapter(createDummyData(), context!!))
        return view
    }

    private fun createDummyData() : MutableList<Food> {
        var dummyFoodList : MutableList<Food> = mutableListOf()
        for (i in 1..5){
            var food : Food = Food()
            food.foodName = "Pizza"
            food.foodContent = "mozerela"
            food.sizeDetails = "78 gram"
            food.price = "67"
            dummyFoodList.add(food)
        }
        return dummyFoodList
    }

}
