package com.innovationfactorytest.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.innovationfactorytest.R
import com.innovationfactorytest.register.RegisterActivity
import kotlinx.android.synthetic.main.second_splash_layout.view.*

class SecondFragment(var viewPager2: ViewPager2) : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.second_splash_layout, container, false)
        v. ivSecondSplashButton?.setOnClickListener {
            viewPager2.setCurrentItem(2, true)

        }

        v. tvSkip?.setOnClickListener {
            startActivity(Intent(activity, RegisterActivity::class.java))

        }

        return v
    }

    }
