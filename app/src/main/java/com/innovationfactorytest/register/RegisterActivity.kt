package com.innovationfactorytest.register

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.innovationfactorytest.R
import kotlinx.android.synthetic.main.login_fragment.*

class RegisterActivity : AppCompatActivity() {
    var myAdapter: RegisterViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }


        myAdapter = RegisterViewPagerAdapter(supportFragmentManager, lifecycle)
        myAdapter?.addFragment(LoginFragment(viewPager2Register))
        myAdapter?.addFragment(RegisterFragment(viewPager2Register))
        viewPager2Register.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2Register.adapter = myAdapter
        viewPager2Register.isNestedScrollingEnabled = true

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position==0)
                    viewPager2Register.setCurrentItem(0, true)
                else
                {
                    viewPager2Register.setCurrentItem(1, true)

                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}


