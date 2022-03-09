package com.amvlabs.kotlinsamples.pickets

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.amvlabs.kotlinsamples.databinding.ActivityDobCalculatorBinding
import org.joda.time.Period
import org.joda.time.PeriodType
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DobCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDobCalculatorBinding
    private lateinit var mContext: Context
    private lateinit var mPresentDate: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDobCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context
        val mCalendar = Calendar.getInstance()
        mPresentDate =
            "${mCalendar.get(Calendar.DAY_OF_MONTH)}/${mCalendar.get(Calendar.MONTH) + 1}/${
                mCalendar.get(Calendar.YEAR)
            }"

        binding.dobTv.setOnClickListener {
            val mCalendar = Calendar.getInstance()
            val mCalendar1 = Calendar.getInstance()
            mCalendar1.add(Calendar.YEAR, -97)
            val minDate = mCalendar1.timeInMillis
            val maxDate = mCalendar.timeInMillis
            datePickerShow(mContext, binding.dobTv, mCalendar, minDate, maxDate)
        }

        binding.presentDateTv.setOnClickListener {

            val mCalendar1 = Calendar.getInstance()
            mCalendar1.add(Calendar.YEAR, +100)

            val formatter = SimpleDateFormat("dd/MM/yyyy")
            val date = formatter.parse(binding.dobTv.text.toString())
            val cal = Calendar.getInstance()
            cal.time = date
            cal.add(Calendar.DAY_OF_MONTH, +2)
            val minDate = cal.timeInMillis
            val maxDate = mCalendar1.timeInMillis
            datePickerShow(mContext, binding.presentDateTv, cal, minDate, maxDate)
        }


        binding.calculateDob.setOnClickListener {
            if (binding.presentDateTv.text.toString()
                    .equals("Dob Calculated",false) && !binding.selectCurrentDate.isChecked
            ) {
                binding.dobCalculated.text = "Please Select the Date or Select the Checkbox"
            } else if (!binding.selectCurrentDate.isChecked) {
                mPresentDate = binding.presentDateTv.text.toString()
                calculateDob(mContext, binding.dobTv.text.toString(), mPresentDate)
            } else if (binding.selectCurrentDate.isChecked) {
                calculateDob(mContext, binding.dobTv.text.toString(), mPresentDate)
            }
        }

    }


    private fun calculateDob(
        mContext: Context,
        dob: String,
        calculatedDate: String
    ) {

        val simpleDateFormat1 = SimpleDateFormat("dd/MM/yyyy")
        try {
            // converting it to date format
            val date1 = simpleDateFormat1.parse(dob)
            val date2 = simpleDateFormat1.parse(calculatedDate)
            val startdate = date1.time
            val endDate = date2.time

            // condition
            if (startdate <= endDate) {
                val period: Period = Period(startdate, endDate, PeriodType.yearMonthDay())
                val years: Int = period.getYears()
                val months: Int = period.getMonths()
                val days: Int = period.getDays()

                // show the final output
                binding.dobCalculated.text = if (years < 18) {
                    "Not Eligible for voting"
                } else {
                    "Your Age is $years Years $months Months $days Days"
                }
            } else {
                // show message
                Toast.makeText(
                    mContext,
                    "BirthDate should not be larger then today's date!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }

//        val years = 29
//        val months = 5
//        val days = 12
//        binding.dobCalculated.text = "Your Age is $years Years $months Months $days Days"


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
                textView.text = "$dobDay/${dobMonth + 1}/$dobYear"
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