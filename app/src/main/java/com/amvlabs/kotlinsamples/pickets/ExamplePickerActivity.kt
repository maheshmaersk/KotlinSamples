package com.amvlabs.kotlinsamples.pickets

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityExamplePickerBinding
import com.amvlabs.kotlinsamples.databinding.ActivityLifeCycleBinding
import java.util.*

class ExamplePickerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExamplePickerBinding

    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamplePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = binding.root.context

        val calendarDate = Calendar.getInstance()
        binding.btDatePicker.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                mContext,
                { view, year, monthOfYear, dayOfMonth ->
                    var dobYear = year
                    var dobMonth = monthOfYear
                    var dobDay = dayOfMonth
                    Toast.makeText(
                        mContext,
                        "Date is $dobDay/$dobMonth/$dobYear",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                },
                calendarDate.get(Calendar.YEAR),
                calendarDate.get(Calendar.MONTH),
                calendarDate.get(Calendar.DAY_OF_MONTH)
            )
            val datePicker = datePickerDialog.datePicker
            datePicker.minDate = System.currentTimeMillis() - 1000

            calendarDate.add(Calendar.MONTH, 6)
            datePicker.maxDate = calendarDate.timeInMillis

            datePickerDialog.show()
        }

        binding.btTImePicker.setOnClickListener {
            val calendarDate = Calendar.getInstance()
            var timePickerDialog =
                TimePickerDialog(mContext, { view: TimePicker?, hourOfDay: Int, minute: Int ->
                    Toast.makeText(
                        mContext,
                        "Time is $hourOfDay/$minute",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }, calendarDate.get(Calendar.HOUR), calendarDate.get(Calendar.MINUTE), true).show()


        }
    }
}