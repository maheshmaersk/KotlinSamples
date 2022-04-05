package com.amvlabs.kotlinsamples.viewpagersample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.amvlabs.kotlinsamples.databinding.ActivityWalkThorughBinding
import com.google.android.material.tabs.TabLayout

class WalkThroughActivity : AppCompatActivity() {


    val TAG = WalkThroughActivity::class.java.simpleName
    private lateinit var binding: ActivityWalkThorughBinding
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkThorughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context


//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CHATS"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("STATUS"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CALLS"))
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        binding.contentPager.adapter = TabPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.contentPager)
    }
}