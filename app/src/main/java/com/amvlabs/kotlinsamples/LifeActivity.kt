package com.amvlabs.kotlinsamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.amvlabs.kotlinsamples.databinding.ActivityLifeBinding
import com.amvlabs.kotlinsamples.databinding.ActivityOnBoardingBinding

class LifeActivity : AppCompatActivity() {

    val TAG = LifeActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var acbar = supportActionBar
        acbar?.setDisplayHomeAsUpEnabled(true)

        Log.e(TAG, "onCreate")
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.e(TAG, "Back Clicked")

        onBackPressed()
        return super.onSupportNavigateUp()
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

    override fun onBackPressed() {
        super.onBackPressed()
    }

}