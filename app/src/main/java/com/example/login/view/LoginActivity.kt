package com.example.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.login.R
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.model.LoginModel
import com.example.login.viewmodel.LoginViewModel
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var viewModel: LoginViewModel? = null
    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding!!.viewModel = viewModel

        loginValidation()

    }

    private fun loginValidation() {

        viewModel!!.login.observe(this, androidx.lifecycle.Observer { loginModel: LoginModel ->

            if (TextUtils.isEmpty(Objects.requireNonNull<LoginModel>(loginModel).strPhoneOrEmail)) {
                binding!!.etLoginEmail.error = "Enter Phone No/Email"
                binding!!.etLoginEmail.requestFocus()
            }
            else if (!loginModel.isValidEmail || !loginModel.isValidEmail) {
                binding!!.etLoginEmail.error = "Enter valid Phone No/Email"
                binding!!.etLoginEmail.requestFocus()
            }
            else if (TextUtils.isEmpty(Objects.requireNonNull<LoginModel>(loginModel).strPassword )) {
                binding!!.etLoginPassword.error = "Enter Password"
                binding!!.etLoginPassword.requestFocus()
            }
            else if (!loginModel.isPasswordValid) {
                binding!!.etLoginPassword.error = "Password Not Valid"
                binding!!.etLoginPassword.requestFocus()
            }
            else {
                Toast.makeText(applicationContext,"Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
