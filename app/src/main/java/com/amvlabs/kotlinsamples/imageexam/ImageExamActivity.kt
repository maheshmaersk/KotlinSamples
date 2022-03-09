package com.amvlabs.kotlinsamples.imageexam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.ActivityExamplePickerBinding
import com.amvlabs.kotlinsamples.databinding.ActivityImageExamBinding
import com.squareup.picasso.Picasso

class ImageExamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageExamBinding

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageExamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = binding.root.context


        binding.loadImage.setOnClickListener {

            if (binding.etMoviePosterURL.text.toString().trim().isEmpty()) {
                binding.moviePosterURLTil.error = " Please paste your image URL"
            } else {
                binding.moviePosterURLTil.error = null
                Picasso.get().load(binding.etMoviePosterURL.text.toString())
                    .placeholder(R.drawable.ic_movie_placeholder)
                    .error(R.drawable.ic_movie_error).into(binding.dynamicImage);
            }
        }
    }
}