package com.amvlabs.kotlinsamples.mvvmSample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityMvvmsampleBinding
import com.amvlabs.kotlinsamples.mvvmSample.viewmodel.AppViewModel


class MVVMSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_mvvmsample)

        var activitySampleBinding: ActivityMvvmsampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_mvvmsample)
        activitySampleBinding.usermodel = AppViewModel()
        activitySampleBinding.executePendingBindings()
    }

    @BindingAdapter("toastMessage")
    fun runMe(view: View, message: String?) {
        if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
    }
}