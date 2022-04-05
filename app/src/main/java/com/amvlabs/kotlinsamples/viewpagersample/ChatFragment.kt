package com.amvlabs.kotlinsamples.viewpagersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amvlabs.kotlinsamples.R
import com.amvlabs.kotlinsamples.databinding.FragmentCallsBinding
import com.amvlabs.kotlinsamples.databinding.FragmentChatBinding
import com.amvlabs.kotlinsamples.databinding.FragmentLoginBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChatFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentChatBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChatFragment().apply {

            }
    }
}