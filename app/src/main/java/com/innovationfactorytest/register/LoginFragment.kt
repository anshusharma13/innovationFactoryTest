package com.innovationfactorytest.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.innovationfactorytest.R
import kotlinx.android.synthetic.main.first_splash_layout.view.*

class LoginFragment(var viewPager2: ViewPager2) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val v: View = inflater.inflate(R.layout.activity_register, container, false)
        v. ivFirstSplashButton?.setOnClickListener {
            viewPager2.setCurrentItem(1, true);

        }

        return v
    }
}