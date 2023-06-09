package com.example.truelinksocial.ui.after_Sign_up_onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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
        binding.btGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingQuestionsFragment_to_onboardingChooseAvatarFragment)
        }
        workingWithSeekBars()
        return binding.root
    }

    private fun workingWithSeekBars() {
        binding.numberOfFriends.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        binding.seekBarTimeBeingSingle.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}