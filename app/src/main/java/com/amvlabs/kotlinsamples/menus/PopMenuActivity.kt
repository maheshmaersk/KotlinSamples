package com.amvlabs.kotlinsamples.menus

import android.content.Context
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityExamplePopMenuBinding

class PopMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExamplePopMenuBinding
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamplePopMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mContext = binding.root.context

        binding.btPopExam.setOnClickListener {
            val popMenu = PopupMenu(mContext, binding.btPopExam)

            popMenu.menuInflater.inflate(R.menu.menu_life, popMenu.menu)

            popMenu.setOnMenuItemClickListener { item ->
                Toast.makeText(mContext, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
                    .show()
                true
            }
            popMenu.show()
        }
        binding.tvPopEx.setOnClickListener {
            val popMenu = PopupMenu(mContext, binding.tvPopEx)

            popMenu.menuInflater.inflate(R.menu.menu_home, popMenu.menu)

            popMenu.setOnMenuItemClickListener { item->  true }

            popMenu.show()
        }
    }
}