package com.amvlabs.kotlinsamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.amvlabs.kotlinsamples.databinding.ActivityLifeBinding
import com.amvlabs.kotlinsamples.databinding.ActivityLifeCycleBinding
import com.amvlabs.kotlinsamples.databinding.ActivityOnBoardingBinding

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

    //onstart oncreate onresume onpause onstop onrestart ondestroy
}