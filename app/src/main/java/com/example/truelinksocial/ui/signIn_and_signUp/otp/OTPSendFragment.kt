package com.example.truelinksocial.ui.signIn_and_signUp.otp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOTPSendBinding


class OTPSendFragment :Fragment() {
    private lateinit var binding: FragmentOTPSendBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_o_t_p_send, container, false)

        binding.btnGetOtp.setOnClickListener {
            findNavController().navigate(R.id.action_OTPSendFragment_to_OTPVerificationFragment)
        }
        backButton()
        return binding.root
    }
    private fun backButton(){
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}