package com.amvlabs.kotlinsamples

import android.content.DialogInterface
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
import android.widget.RatingBar
import android.widget.SeekBar

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class LifeCycleActivity : AppCompatActivity() {
    val TAG = LifeCycleActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeCycleBinding
    private var seekProgress: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logsds.setOnClickListener {
            startActivity(Intent(it.context, LifeActivity::class.java))
        }

        binding.alertDialogbt.setOnClickListener { v ->
            var slert = MaterialAlertDialogBuilder(v.context)
            slert.setTitle("Exit Message")
            slert.setMessage("Do you want to exit the app")
            slert.setPositiveButton("ok") { dialogInterface: DialogInterface, i: Int ->
                run {
                    Toast.makeText(v.context, "Thanks for commenting", Toast.LENGTH_SHORT).show()
                }
            }
            slert.setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int ->
                run {
                    Toast.makeText(v.context, "Thanks for commenting", Toast.LENGTH_SHORT).show()
                }
            }
            slert.setNeutralButton("Dono") { dialogInterface: DialogInterface, i: Int ->
                run {
                    Toast.makeText(v.context, "Thanks for commenting", Toast.LENGTH_SHORT).show()
                }
            }
            val alertDialog = slert.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        binding.ratingApp.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(ratingBar?.context, "Rating is $rating", Toast.LENGTH_SHORT)
                .show()
        }

        binding.selectedRatingTv.setOnClickListener {
            Snackbar.make(it,"Rating is ${binding.ratingApp.rating}",Snackbar.LENGTH_SHORT).setAction("undo") { v12 ->
                Log.e(TAG, "Redo")
            }.show()
        }

        binding.musicVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekProgress=progress
                Log.e(TAG,"onProgress $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.e(TAG,"onStartTrackingTouch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.e(TAG,"onStopTrackingTouch")
            }
        })

        binding.seekValue.setOnClickListener {
            Toast.makeText(it?.context, "Seek is $seekProgress", Toast.LENGTH_SHORT)
                .show()
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

//        super.onBackPressed()
    }

    //onstart oncreate onresume onpause onstop onrestart ondestroy
}