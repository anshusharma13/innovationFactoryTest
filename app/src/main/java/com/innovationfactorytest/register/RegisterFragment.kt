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
import com.innovationfactorytest.util.InputValidatorHelper
import kotlinx.android.synthetic.main.register_fragment.view.*

class RegisterFragment(var viewPager2: ViewPager2) : Fragment(), View.OnClickListener {
    private var random: Int=0
    private var v: View? = null
    private var db: DBHelper? = null
    private  var validator: InputValidatorHelper?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.register_fragment, container, false)
        db = DBHelper(requireActivity(), null)
        val random1 = (0..100).shuffled().last()
         random = random1
        validator = InputValidatorHelper(requireActivity())

     //   v?.btnSignUp?.setOnClickListener(this)
        v?.btnSignUp?.setOnClickListener {
            if (validator!!.isValidIndividualSupplierSignUp(
                    v?.etFirstName!!,
                    v?.etLastName!!,
                    v?.etEmailName!!,
                    v?.etPassword!!,
                    v?.etConfirmPass!!
                )
            ) {
                val name = v?.etFirstName?.text.toString()
                val lastName = v?.etLastName?.text.toString()
                val email = v?.etEmailName?.text.toString()
                val password = v?.etPassword?.text.toString()

                val fullName = "$name $lastName"


                // calling method to add
                // name to our database
                db?.addName(random,fullName, email, password)

                Toast.makeText(
                    requireActivity(),
                    "$fullName Added to database",
                    Toast.LENGTH_LONG
                ).show()

                // at last, clearing edit texts
                v?.etFirstName?.text?.clear()
                v?.etLastName?.text?.clear()
                v?.etPassword?.text?.clear()
                v?.etEmailName?.text?.clear()

            }

        }


        return v
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.btnSignUp -> {


            }
        }
    }
}