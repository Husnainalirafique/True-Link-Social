package com.example.truelinksocial.ui.after_Sign_up_onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOnboardingQuestionsBinding

class OnboardingQuestionsFragment :Fragment() {
    private lateinit var binding: FragmentOnboardingQuestionsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding_questions, container, false)
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}