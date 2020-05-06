package com.example.login.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.model.LoginModel

class LoginViewModel: ViewModel() {

    var phoneOrEmail = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var loginMutableLiveData: MutableLiveData<LoginModel>? = null

    val login: MutableLiveData<LoginModel>
        get() {
            if (loginMutableLiveData == null) {
                loginMutableLiveData = MutableLiveData()
            }
            return loginMutableLiveData as MutableLiveData<LoginModel>
        }

    fun btnLoginOnClick() {



        try {
            //Log.d("newPassword",newPassword.value!!.toString())
            //Log.d("newPassword",confirmPassword.value!!.toString())
            val loginModel =
                LoginModel(
                    phoneOrEmail.value.toString(),
                    password.value.toString()
                )
            loginMutableLiveData!!.value = loginModel


        } catch (e: Exception) {
            Log.d("loginOnClick", e.toString())
        }

    }
}
