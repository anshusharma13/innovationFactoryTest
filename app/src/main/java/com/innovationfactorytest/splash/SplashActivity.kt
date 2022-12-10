package com.innovationfactorytest.splash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.google.android.material.tabs.TabLayoutMediator
import com.innovationfactorytest.R

import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : AppCompatActivity() {
    var myAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }


        myAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        myAdapter?.addFragment(FirstFragment(viewPager2))
        myAdapter?.addFragment(SecondFragment(viewPager2))
        myAdapter?.addFragment(ThirdFragment(viewPager2))
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.adapter = myAdapter
        viewPager2?.let {
            tab_layout?.let { it1 ->
                TabLayoutMediator(it1, it) { _, _ ->
                }.attach()
            }
        }

    }


}