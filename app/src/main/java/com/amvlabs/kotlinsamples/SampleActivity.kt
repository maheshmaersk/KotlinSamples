package com.amvlabs.kotlinsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)


        val intVal = intent.extras

        val username:String = intVal?.getString("luser").toString()
        val password:String = intVal?.getString("lpass").toString()


        Log.w("Login UserName1",username)
        Log.i("Login Password1",password)
    }
}