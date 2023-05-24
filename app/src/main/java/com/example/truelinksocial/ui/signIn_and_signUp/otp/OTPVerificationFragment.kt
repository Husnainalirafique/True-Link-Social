package com.example.truelinksocial.ui.signIn_and_signUp.otp

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOTPVerificationBinding

class OTPVerificationFragment :Fragment() {
    private lateinit var binding: FragmentOTPVerificationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_o_t_p_verification, container, false)

        otpEditTextFunctionality()
        backButton()
        buttonConfirm()
        return binding.root
    }
    private fun otpEditTextFunctionality(){
        val pinEditText1 = binding.edittextPin1
        val pinEditText2 = binding.edittextPin2
        val pinEditText3 = binding.edittextPin3
        val pinEditText4 = binding.edittextPin4

        pinEditText1.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                // Handle backspace/delete key press to move focus to the previous EditText
                if (pinEditText1.text.isEmpty()) {
                    pinEditText1.clearFocus()
                    pinEditText1.requestFocus()
                }
            } else if (event.action == KeyEvent.ACTION_DOWN && keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
                // Move focus to the next EditText after entering a digit
                pinEditText1.clearFocus()
                pinEditText2.requestFocus()
                pinEditText2.isCursorVisible = true
            }
            false
        }

        pinEditText2.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                // Handle backspace/delete key press to move focus to the previous EditText
                if (pinEditText2.text.isEmpty()) {
                    pinEditText2.clearFocus()
                    pinEditText1.requestFocus()
                    pinEditText1.setSelection(pinEditText1.text.length)
                }
            } else if (event.action == KeyEvent.ACTION_DOWN && keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
                // Move focus to the next EditText after entering a digit
                pinEditText2.clearFocus()
                pinEditText3.requestFocus()
                pinEditText3.isCursorVisible = true
            }
            false
        }

        pinEditText3.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                // Handle backspace/delete key press to move focus to the previous EditText
                if (pinEditText3.text.isEmpty()) {
                    pinEditText3.clearFocus()
                    pinEditText2.requestFocus()
                    pinEditText2.setSelection(pinEditText2.text.length)
                }
            } else if (event.action == KeyEvent.ACTION_DOWN && keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
                // Move focus to the next EditText after entering a digit
                pinEditText3.clearFocus()
                pinEditText4.requestFocus()
                pinEditText4.isCursorVisible = true
            }
            false
        }

        pinEditText4.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                // Handle backspace/delete key press to move focus to the previous EditText
                if (pinEditText4.text.isEmpty()) {
                    pinEditText4.clearFocus()
                    pinEditText3.requestFocus()
                    pinEditText3.setSelection(pinEditText3.text.length)
                }
            }
            false
        }

    }
    private fun backButton(){
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    private fun buttonConfirm(){
        binding.btnConfirmOtp.setOnClickListener {
            findNavController().navigate(R.id.action_OTPVerificationFragment_to_signUpCompleteFragment)
        }
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}