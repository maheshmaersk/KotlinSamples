package com.amvlabs.kotlinsamples

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amvlabs.kotlinsamples.databinding.ActivityLifeBinding

class LifeActivity : AppCompatActivity() {

    val TAG = LifeActivity::class.java.simpleName
    private lateinit var binding: ActivityLifeBinding
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = binding.root.context

        var acbar = supportActionBar
        acbar?.setDisplayHomeAsUpEnabled(true)

        val stateList = arrayOf(
            "KA",
            "TN",
            "AP",
            "TS",
            "PN",
            "MU",
            "KA",
            "TN",
            "AP",
            "TS",
            "PN",
            "MU",
            "KA",
            "TN",
            "AP",
            "TS",
            "PN",
            "MU",
            "KA",
            "TN",
            "AP",
            "TS",
            "PN",
            "MU"
        )


        var productList = arrayListOf<Product>()

        productList.add(Product("Dell Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("Lenova Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("Mac Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("Aces Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("HP Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("IBall Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("Sony Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("viau Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("MI Smart Laptop", "Feature of china", "18999"))
        productList.add(Product("Alien Smart Laptop", "Feature of china", "18999"))

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_multiple_choice, stateList
        )
//        binding.contactList.adapter = adapter


        var baseAdapter = ProductAdapter(binding.contactList.context, productList)
        binding.contactList.adapter = baseAdapter

        binding.contactList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    binding.contactList.context,
                    "${binding.contactList.getItemAtPosition(position)}",
                    Toast.LENGTH_SHORT
                ).show()
            }


        val animationFadeIn =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.fade_in)
        val animationFadeOut =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.fade_out)
        val animationZoomIn =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.zoom_in)
        val animationZoomOut =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.zoom_out)
        val animationSlideIn =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.slide_up)
        val animationSlideOut =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.slide_down)
        val animationRotate =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.rotate)
        val animationBounce =
            AnimationUtils.loadAnimation(this, com.amvlabs.kotlinsamples.R.anim.bounce)


        binding.bounce.setOnClickListener {
            binding.moviePoster.startAnimation(animationBounce)
        }
        binding.rotate.setOnClickListener {
            binding.moviePoster.startAnimation(animationRotate)
        }
        binding.slideIn.setOnClickListener {
            binding.moviePoster.startAnimation(animationSlideIn)
        }
        binding.slideOut.setOnClickListener {
            binding.moviePoster.startAnimation(animationSlideOut)
        }
        binding.zoomIn.setOnClickListener {
            binding.moviePoster.startAnimation(animationZoomIn)
        }
        binding.zoomOut.setOnClickListener {
            binding.moviePoster.startAnimation(animationZoomOut)
        }
        binding.fadeIn.setOnClickListener {
            binding.moviePoster.startAnimation(animationFadeIn)
        }
        binding.fadeOut.setOnClickListener {
            binding.moviePoster.startAnimation(animationFadeOut)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        Log.e(TAG, "Back Clicked")

        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_life, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val register = menu!!.findItem(R.id.menuPayment)
        register.isVisible = false //userRegistered is boolean, pointing if the user has registered or not.
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent: Intent = Intent(mContext, LifeCycleActivity::class.java)
        when (item.itemId) {
            R.id.menuLife -> {
                intent = Intent(mContext, LifeCycleActivity::class.java)
            }
            R.id.menuPayment -> {
                intent = Intent(mContext, MainActivity::class.java)
            }
            R.id.menuSound -> {
                intent = Intent(mContext, SampleActivity::class.java)
            }
        }
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}