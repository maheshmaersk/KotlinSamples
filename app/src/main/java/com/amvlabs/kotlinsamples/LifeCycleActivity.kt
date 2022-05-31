package com.amvlabs.kotlinsamples

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amvlabs.kotlinsamples.camera.CameraSampleActivity
import com.amvlabs.kotlinsamples.databinding.ActivityExamplePickerBinding
import com.amvlabs.kotlinsamples.databinding.ActivityLifeCycleBinding
import com.amvlabs.kotlinsamples.fragmentsample.FragmentSampleActivity
import com.amvlabs.kotlinsamples.imageexam.ImageExamActivity
import com.amvlabs.kotlinsamples.menus.PopMenuActivity
import com.amvlabs.kotlinsamples.mvvmSample.MVVMSampleActivity
import com.amvlabs.kotlinsamples.pickets.ExamplePickerActivity
import com.amvlabs.kotlinsamples.retrofitsample.ApiResponseActivity
import com.amvlabs.kotlinsamples.viewpagersample.WalkThroughActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.messaging.FirebaseMessaging


class LifeCycleActivity : AppCompatActivity() {
    val TAG = LifeCycleActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeCycleBinding
    lateinit var mContext: Context
    private var seekProgress: Int = 0
    var mAudio: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mContext = binding.root.context



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW
                )
            )
        }

        intent.extras?.let {
            for (key in it.keySet()) {
                val value = intent.extras?.get(key)
                Log.d(TAG, "Key: $key Value: $value")
            }
        }

        mAudio = getSystemService(Context.AUDIO_SERVICE) as AudioManager?
        initControls(binding.musicVolume, AudioManager.STREAM_MUSIC);
        binding.logsds.setOnClickListener {
            startActivity(Intent(it.context, LifeActivity::class.java))
        }
        binding.popMenu.setOnClickListener {
            startActivity(Intent(it.context, PopMenuActivity::class.java))
        }
        binding.pickers.setOnClickListener {
            startActivity(Intent(it.context, ExamplePickerActivity::class.java))
        }
        binding.imageExample.setOnClickListener {
            startActivity(Intent(it.context, ImageExamActivity::class.java))
        }
        binding.fragments.setOnClickListener {
            startActivity(Intent(it.context, FragmentSampleActivity::class.java))
        }
        binding.pagerExample.setOnClickListener {
            startActivity(Intent(it.context, WalkThroughActivity::class.java))
        }
        binding.mvvmSample.setOnClickListener {
            startActivity(Intent(it.context, MVVMSampleActivity::class.java))
        }

        binding.retrofitSample.setOnClickListener {
            startActivity(Intent(it.context, ApiResponseActivity::class.java))
        }
        binding.cameraSample.setOnClickListener {
            startActivity(Intent(it.context, CameraSampleActivity::class.java))
        }

        binding.FCMMessaging.setOnClickListener {
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result

                // Log and toast
                val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })
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
            Snackbar.make(it, "Rating is ${binding.ratingApp.rating}", Snackbar.LENGTH_SHORT)
                .setAction("undo") { v12 ->
                    Log.e(TAG, "Redo")
                }.show()
        }

//        binding.musicVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                seekProgress=progress
//                Log.e(TAG,"onProgress $progress")
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                Log.e(TAG,"onStartTrackingTouch")
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                Log.e(TAG,"onStopTrackingTouch")
//            }
//        })

        binding.seekValue.setOnClickListener {
            Toast.makeText(
                it?.context,
                "Seek is ${binding.musicVolume.progress}",
                Toast.LENGTH_SHORT
            )
                .show()
        }

        val stateList = arrayOf("KA", "TN", "AP", "TS", "PN", "MU")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, stateList
        )
        binding.states.adapter = adapter

//        binding.countries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>,
//                                        view: View, position: Int, id: Long) {
//                val capital: String = when(position){
//                     0 -> "Delhi"
//                     1 -> "Sydney"
//                     2 -> "trsdf"
//                     3 -> "jhgjhgj"
//                     4 -> "Sydnehdfsdfsdfy"
//                     5 -> "sdfd"
//                     6 -> "Morning"
//                    else -> "dummy"
//                }
//                Snackbar.make(view,"Capital is $capital",Snackbar.LENGTH_SHORT).show()
//
//                Toast.makeText(binding.countries.context, "${binding.countries.selectedItem}  ${binding.countries.selectedItemId} $position $id", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // write code to perform some action
//            }
//        }

//        binding.states.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>,
//                                        view: View, position: Int, id: Long) {
//                Toast.makeText(binding.countries.context, "${binding.states.selectedItem}  ${binding.states.selectedItemId} $position $id", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // write code to perform some action
//            }
//        }

        Log.e(TAG, "onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent: Intent = Intent(mContext, LifeActivity::class.java)
        when (item.itemId) {
            R.id.menuProfile -> {
                intent = Intent(mContext, LifeActivity::class.java)
            }
            R.id.menuTheme -> {
                intent = Intent(mContext, MainActivity::class.java)
            }
            R.id.menuSettings -> {
                intent = Intent(mContext, SampleActivity::class.java)
            }
        }
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    /*INFO : Followed from https://studyviewer.com/android-control-volume-programmatically/
    * Handling of Music Volumes based on Streams*/

    private fun initControls(seek: SeekBar, stream: Int) {
        seek.max = mAudio!!.getStreamMaxVolume(stream)
        seek.progress = mAudio!!.getStreamVolume(stream)
        seek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean) {
                mAudio!!.setStreamVolume(stream, progress, AudioManager.FLAG_PLAY_SOUND)
            }

            override fun onStartTrackingTouch(bar: SeekBar) {}
            override fun onStopTrackingTouch(bar: SeekBar) {}
        })
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