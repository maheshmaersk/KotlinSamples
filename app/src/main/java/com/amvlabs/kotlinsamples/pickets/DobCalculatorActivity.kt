package com.amvlabs.kotlinsamples.pickets

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityDobCalculatorBinding
import com.amvlabs.kotlinsamples.databinding.ActivityExamplePickerBinding
import java.text.SimpleDateFormat
import java.util.*

class DobCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDobCalculatorBinding
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDobCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context
        binding.dobTv.setOnClickListener {
            val mCalendar = Calendar.getInstance()
            val mCalendar1 = Calendar.getInstance()
            mCalendar1.add(Calendar.YEAR, -97)
            val minDate = mCalendar1.timeInMillis
            val maxDate = mCalendar.timeInMillis
            datePickerShow(mContext, binding.dobTv, mCalendar, minDate, maxDate)
        }

        binding.presentDateTv.setOnClickListener {
            val mCalendar = Calendar.getInstance()
            val mCalendar1 = Calendar.getInstance()
            mCalendar1.add(Calendar.YEAR, +100)

            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val date = formatter.parse(binding.dobTv.text.toString())
            val cal = Calendar.getInstance()
            cal.time = date
            cal.add(Calendar.DAY_OF_MONTH,+2)
            val minDate = cal.timeInMillis
            val maxDate = mCalendar1.timeInMillis
            datePickerShow(mContext, binding.presentDateTv, cal, minDate, maxDate)
        }

    }


    fun datePickerShow(
        mContext: Context,
        textView: AppCompatTextView,
        defaultSetDate: Calendar,
        minDate: Long,
        maxDate: Long
    ) {
        val datePickerDialog = DatePickerDialog(
            mContext,
            { view, year, monthOfYear, dayOfMonth ->
                val dobYear = year
                val dobMonth = monthOfYear
                val dobDay = dayOfMonth
                textView.text = "$dobDay/${dobMonth+1}/$dobYear"
            },
            defaultSetDate.get(Calendar.YEAR),
            defaultSetDate.get(Calendar.MONTH),
            defaultSetDate.get(Calendar.DAY_OF_MONTH)
        )
        val datePicker = datePickerDialog.datePicker
        datePicker.minDate = minDate
        datePicker.maxDate = maxDate
        datePickerDialog.show()
    }
}