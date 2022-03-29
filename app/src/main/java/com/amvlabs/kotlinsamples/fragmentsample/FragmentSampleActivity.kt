package com.amvlabs.kotlinsamples.fragmentsample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityFragmentSampleBinding

class FragmentSampleActivity : AppCompatActivity() {
    val TAG = FragmentSampleActivity::class.java.simpleName
    private lateinit var binding: ActivityFragmentSampleBinding
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context

        val fManager = supportFragmentManager


        binding.addA.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            fTransaction.add(R.id.fragmentView,SFragment.newInstance(), SFragment::class.java.simpleName)
            fTransaction.commit()
        }
        binding.addB.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            fTransaction.add(R.id.fragmentView, LoginFragment.newInstance(), LoginFragment::class.java.simpleName)
            fTransaction.commit()
        }

        binding.remA.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            val fragment = fManager.findFragmentByTag(SFragment::class.java.simpleName)
            fragment?.let { it1 -> fTransaction.remove(it1) }
            fTransaction.commit()
        }
        binding.remB.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            val fragment = fManager.findFragmentByTag(LoginFragment::class.java.simpleName)
            fragment?.let { it1 -> fTransaction.remove(it1) }
            fTransaction.commit()
        }

        binding.showA.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            val fragment = fManager.findFragmentByTag(SFragment::class.java.simpleName)
            fragment?.let { it1 -> fTransaction.show(it1) }
            fTransaction.commit()
        }
        binding.hideA.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            val fragment = fManager.findFragmentByTag(SFragment::class.java.simpleName)
            fragment?.let { it1 -> fTransaction.hide(it1) }
            fTransaction.commit()
        }

        binding.repA.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            fTransaction.replace(R.id.fragmentView,SFragment.newInstance(), SFragment::class.java.simpleName)
            fTransaction.commit()
        }
        binding.repB.setOnClickListener {
            val fTransaction = fManager.beginTransaction()
            fTransaction.replace(R.id.fragmentView, LoginFragment.newInstance(), LoginFragment::class.java.simpleName)
            fTransaction.commit()
        }
    }
}