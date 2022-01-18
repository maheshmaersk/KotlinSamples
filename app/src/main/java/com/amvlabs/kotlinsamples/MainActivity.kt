package com.amvlabs.kotlinsamples

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var mContext: Context
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginGroup: Group = findViewById(R.id.loginGroup)
        var singUpGroup = findViewById<Group>(R.id.signUpGroup)

        var registerBt = findViewById<AppCompatButton>(R.id.registerBT)
        var loginBt = findViewById<AppCompatButton>(R.id.btLogin)
        var etUserName = findViewById<TextInputEditText>(R.id.etUserName)
        var etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        var mainLayout = findViewById<ConstraintLayout>(R.id.topLayout)
        var tilUsername = findViewById<TextInputLayout>(R.id.tilUsername)
        mContext = mainLayout.context

        registerBt.setOnClickListener {
            if (registerBt.text.toString().equals("Register", true)) {
                registerBt.text = "Login"
                singUpGroup.visibility = View.VISIBLE
                loginGroup.visibility = View.GONE
            } else {
                registerBt.text = "Register"
                singUpGroup.visibility = View.GONE
                loginGroup.visibility = View.VISIBLE
            }
        }

        loginBt.setOnClickListener {
            val userNam = etUserName.text.toString()
            val userPass = etPassword.text.toString()
            Log.e(TAG, userNam)
            Log.d(TAG, userPass)


            when {
                userNam.trim().isEmpty() -> {
                    tilUsername.error = "Please Enter UserName"
                    Toast.makeText(mContext, "Please Enter UserName", Toast.LENGTH_SHORT).show()
                }
                userPass.trim().isEmpty() -> {
                    Toast.makeText(mContext, "Please Enter Password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    var intent = Intent(mContext, SampleActivity::class.java)
                    intent.putExtra("luser", etUserName.text.toString())
                    intent.putExtra("lpass", etPassword.text.toString())
                    startActivity(intent)
                }
            }

        }
    }
}