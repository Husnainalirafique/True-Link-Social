package com.example.truelinksocial.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentRequestBinding

class RequestFragment  :Fragment() {
    private lateinit var binding: FragmentRequestBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_request, container, false)

        return binding.root
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}