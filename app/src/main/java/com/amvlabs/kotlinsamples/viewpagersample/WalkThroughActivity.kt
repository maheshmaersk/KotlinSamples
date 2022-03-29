package com.amvlabs.kotlinsamples.viewpagersample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amvlabs.kotlinsamples.databinding.ActivityWalkThorughBinding

class WalkThroughActivity : AppCompatActivity() {


    val TAG = WalkThroughActivity::class.java.simpleName
    private lateinit var binding: ActivityWalkThorughBinding
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkThorughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context


    }
}