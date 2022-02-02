package com.amvlabs.kotlinsamples

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.amvlabs.kotlinsamples.databinding.ActivityLifeBinding
import com.amvlabs.kotlinsamples.databinding.ActivityOnBoardingBinding

class LifeActivity : AppCompatActivity() {

    val TAG = LifeActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var acbar = supportActionBar
        acbar?.setDisplayHomeAsUpEnabled(true)

        val stateList = arrayOf("KA","TN","AP","TS","PN","MU","KA","TN","AP","TS","PN","MU","KA","TN","AP","TS","PN","MU","KA","TN","AP","TS","PN","MU")


        var productList  = arrayListOf<Product>()

        productList.add(Product("Dell Smart Laptop","Feature of china","18999"))
        productList.add(Product("Lenova Smart Laptop","Feature of china","18999"))
        productList.add(Product("Mac Smart Laptop","Feature of china","18999"))
        productList.add(Product("Aces Smart Laptop","Feature of china","18999"))
        productList.add(Product("HP Smart Laptop","Feature of china","18999"))
        productList.add(Product("IBall Smart Laptop","Feature of china","18999"))
        productList.add(Product("Sony Smart Laptop","Feature of china","18999"))
        productList.add(Product("viau Smart Laptop","Feature of china","18999"))
        productList.add(Product("MI Smart Laptop","Feature of china","18999"))
        productList.add(Product("Alien Smart Laptop","Feature of china","18999"))

        val adapter = ArrayAdapter(this,
            R.layout.simple_list_item_multiple_choice, stateList)
//        binding.contactList.adapter = adapter


        var baseAdapter = ProductAdapter(binding.contactList.context,productList)
        binding.contactList.adapter = baseAdapter

        binding.contactList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id -> Toast.makeText(binding.contactList.context, "${binding.contactList.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show() }
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.e(TAG, "Back Clicked")

        onBackPressed()
        return super.onSupportNavigateUp()
    }


}