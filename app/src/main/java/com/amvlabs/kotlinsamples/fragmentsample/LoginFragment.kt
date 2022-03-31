package com.amvlabs.kotlinsamples.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.fBtLogin.setOnClickListener {
            Toast.makeText(view.context,"UserName is ${binding.fLoginUName.text.toString()}\nPassword is ${binding.fLoginUPass.text.toString()}",Toast.LENGTH_SHORT).show()
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}