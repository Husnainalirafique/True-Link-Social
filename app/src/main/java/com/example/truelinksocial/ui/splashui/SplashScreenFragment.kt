package com.example.truelinksocial.ui.splashui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.ui.home.HomeActivity
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentSplashScreenBinding
@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)

        Handler().postDelayed({
            if (context  != null) {
                if (onBoardingFinished()) {
                   val intent = Intent(requireContext(), HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_onBoardingPagerFragment)
                }
            }
        }, 500)
        return binding.root
    }
    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("finished", false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}