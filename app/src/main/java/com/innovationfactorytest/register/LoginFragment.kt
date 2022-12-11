package com.innovationfactorytest.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.innovationfactorytest.R
import com.innovationfactorytest.util.DBHelper
import kotlinx.android.synthetic.main.activity_register.view.*

class LoginFragment(var viewPager2: ViewPager2) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val v: View = inflater.inflate(R.layout.activity_register, container, false)
        v. btnLogin?.setOnClickListener {

                // creating a DBHelper class
                // and passing context to it
                val db = DBHelper(requireActivity(), null)

                // below is the variable for cursor
                // we have called method to get
                // all names from our database
                // and add to name text view
                val cursor = db.getName()
            cursor!!.moveToFirst()
            cursor.getColumnIndex(DBHelper.EMAIL_COL)

                // moving the cursor to first position and
                // appending value in the text view



                // at last we close our cursor
                cursor.close()
            }



        return v
    }
}