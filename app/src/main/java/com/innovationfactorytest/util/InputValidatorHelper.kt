package com.innovationfactorytest.util

import android.app.Activity
import android.widget.EditText
import android.widget.Toast
import com.innovationfactorytest.R
import java.util.regex.Matcher
import java.util.regex.Pattern

class InputValidatorHelper (val context: Activity) {

    private var isTrue: Boolean = false


    fun isValidIndividualSupplierSignUp(
        firstName: EditText,
        lastName: EditText,
        email: EditText,
        password: EditText,
        confirmPass: EditText,
    ): Boolean {


        if (!isValidName(firstName.text.toString())) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_name),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        }

        else if (!isValidName(lastName.text.toString())) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_lastname),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        }
        else if (!isValidEmail(email.text.toString())) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_email),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        }

        else if (password.text.toString().isEmpty() && !isValidPassword(
                password.text.toString(),
                false
            )
        ) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_password),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        } else if (password.text.toString().length < 8) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_password_length),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        } else if (confirmPass.text.toString().isEmpty() && !isValidPassword(
                confirmPass.text.toString(),
                false
            )
        ) {
            Toast.makeText(
                context,
                context.getString(R.string.enter_valid_confirm_password),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        } else if (confirmPass.text.toString() != password.text.toString()) {
            Toast.makeText(
                context,
                context.getString(R.string.password_confirm_password_should_match),
                Toast.LENGTH_LONG
            ).show()
            isTrue = false
        }  else {
            isTrue = true

        }
        return isTrue
    }

    private fun isValidPassword(
        string: String?,
        allowSpecialChars: Boolean
    ): Boolean {
        val PATTERN: String =
            if (allowSpecialChars) { //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
                "^[a-zA-Z@#$%]\\w{5,19}$"
            } else { //PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
                "^[a-zA-Z]\\w{5,19}$"
            }
        val pattern = Pattern.compile(PATTERN)
        val matcher = pattern.matcher(string!!)
        return matcher.matches()
    }


    private fun isValidName(string: String?): Boolean {
        val NAME_PATTERN =
            "^[A-Za-z0-9\\s]+$"
        val pattern: Pattern = Pattern.compile(NAME_PATTERN)
        val matcher: Matcher = pattern.matcher(string!!)
        return matcher.matches()
    }

    private fun isValidEmail(string: String?): Boolean {
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,64})$"
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(string!!)
        return matcher.matches()
    }

}