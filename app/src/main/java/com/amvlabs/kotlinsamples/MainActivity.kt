package com.amvlabs.kotlinsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginGroup :Group= findViewById(R.id.loginGroup)
        var singUpGroup = findViewById<Group>(R.id.signUpGroup)

        var registerBt = findViewById<AppCompatButton>(R.id.registerBT)

        registerBt.setOnClickListener { if(registerBt.text.toString().equals("Register",true)){
            registerBt.text = "Login"
            singUpGroup.visibility = View.VISIBLE
            loginGroup.visibility = View.GONE
        }else{
            registerBt.text = "Register"
            singUpGroup.visibility = View.GONE
            loginGroup.visibility = View.VISIBLE
        }
        }
    }
}