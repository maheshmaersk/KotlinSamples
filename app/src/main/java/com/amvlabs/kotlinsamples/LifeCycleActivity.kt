package com.amvlabs.kotlinsamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.amvlabs.kotlinsamples.databinding.ActivityLifeBinding
import com.amvlabs.kotlinsamples.databinding.ActivityLifeCycleBinding
import com.amvlabs.kotlinsamples.databinding.ActivityOnBoardingBinding
import android.os.Looper

import android.widget.Toast




class LifeCycleActivity : AppCompatActivity() {
    val TAG = LifeCycleActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeCycleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logsds.setOnClickListener {
            startActivity(Intent(it.context,LifeActivity::class.java))
        }
        Log.e(TAG, "onCreate")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)

        super.onBackPressed()
    }

    //onstart oncreate onresume onpause onstop onrestart ondestroy
}