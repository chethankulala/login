package com.example.login.model

import android.util.Patterns

class LoginModel (val phoneOrEmail: String, val password: String) {

    val strPhoneOrEmail = phoneOrEmail
    val strPassword = password

    val isValidEmail: Boolean
        get() {
            if (Patterns.EMAIL_ADDRESS.matcher(strPhoneOrEmail).matches())
                return true
            else if (strPhoneOrEmail.length == 10)
                return true
            return false
        }

    val isPasswordValid: Boolean
        get() = strPassword.length >= 6
}