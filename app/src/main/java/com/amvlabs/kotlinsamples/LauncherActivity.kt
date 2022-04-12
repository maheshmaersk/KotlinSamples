package com.amvlabs.kotlinsamples

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.amvlabs.kotlinsamples.databinding.ActivityLauncherBinding
import com.amvlabs.kotlinsamples.onboarding.OnBoardingWalkActivity

class LauncherActivity : AppCompatActivity() {

    val TAG = LauncherActivity::class.java.simpleName
    private lateinit var binding: ActivityLauncherBinding
    lateinit var mContext: Context
    private val sharedPrefFile = "kotlinSamples"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)
        mContext = binding.root.context

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)

        // HERE WE ARE TAKING THE REFERENCE OF OUR IMAGE
        // SO THAT WE CAN PERFORM ANIMATION USING THAT IMAGE
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        binding.logoApp.startAnimation(slideAnimation)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({

            val sharedIdValue = sharedPreferences.getBoolean("firstTime",false)
            if(!sharedIdValue){
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putBoolean("firstTime",true)
                editor.apply()
                editor.commit()
                val intent = Intent(this, OnBoardingWalkActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, LifeCycleActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)

    }
}