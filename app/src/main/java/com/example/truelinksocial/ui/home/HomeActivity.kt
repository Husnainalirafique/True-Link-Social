@file:Suppress("DEPRECATION")

package com.example.truelinksocial.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
     private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        //Functions
        statusBarContentVisibility()
        handlingBottomNavBar()
    }
     private fun statusBarContentVisibility() {
             //To make status bar content color black
             window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
         }
    private fun handlingBottomNavBar(){
//        val navController= Navigation.findNavController(this,R.id.homeFragmentContainerView)
//        setupWithNavController(binding.bottomNavigationView,navController)
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.homeFragmentContainerView))
    }
}