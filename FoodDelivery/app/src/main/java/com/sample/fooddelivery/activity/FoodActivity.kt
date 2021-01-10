package com.sample.fooddelivery.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.sample.fooddelivery.R
import com.sample.fooddelivery.adapter.ViewPagerAdapter
import com.sample.fooddelivery.fragment.FoodFragment

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        //setSupportActionBar(findViewById(R.id.toolbar))

        var height : Int = Math.round(resources.displayMetrics.heightPixels * (3.toFloat() / 4.toFloat()))
        val appbar = findViewById(R.id.app_bar) as AppBarLayout
        val im_toolbar = findViewById(R.id.im_toolbar) as ImageView
        var params: ViewGroup.LayoutParams = appbar.getLayoutParams()
        params.height = height
        appbar.layoutParams = params
        params = im_toolbar.getLayoutParams()
        params.height = height
        im_toolbar.layoutParams = params
        var tv_fab = findViewById(R.id.tv_fab) as TextView
        tv_fab.visibility = View.GONE

        val mViewPager: ViewPager = findViewById(R.id.viewpager) as ViewPager
        val mViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        mViewPagerAdapter.addFragment(FoodFragment(), "Pizza")
        mViewPagerAdapter.addFragment(FoodFragment(), "Sushi")
        mViewPagerAdapter.addFragment(FoodFragment(), "Drinks")
        mViewPager.setAdapter(mViewPagerAdapter)

        val tabLayout: TabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            val intent = Intent(this, MenuActivity::class.java)
            startActivity (intent)

        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}