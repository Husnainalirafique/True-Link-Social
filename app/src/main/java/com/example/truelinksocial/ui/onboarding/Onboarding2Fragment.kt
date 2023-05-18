package com.example.truelinksocial.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOnboarding2Binding
import com.example.truelinksocial.databinding.FragmentOnboarding3Binding


class Onboarding2Fragment :Fragment() {
    private lateinit var binding: FragmentOnboarding2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding2, container, false)

        return binding.root
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}