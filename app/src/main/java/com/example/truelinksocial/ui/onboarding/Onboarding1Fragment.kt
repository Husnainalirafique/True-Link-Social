package com.example.truelinksocial.ui.onboarding

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOnboarding1Binding

class Onboarding1Fragment : Fragment() {
    private lateinit var binding: FragmentOnboarding1Binding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding1, container, false)


        return binding.root
    }

}