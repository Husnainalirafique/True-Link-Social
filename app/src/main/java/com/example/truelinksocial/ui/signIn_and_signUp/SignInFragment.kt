package com.example.truelinksocial.ui.signIn_and_signUp

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentSignInBinding

@SuppressLint("ClickableViewAccessibility")
class SignInFragment :Fragment() {
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        val editText = binding.signInPasswordEdittext
        passwordVisibility(editText)
        registerNow()
        return binding.root
    }

    private fun registerNow(){
        binding.registerNow.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
    private fun passwordVisibility(editText:EditText) {
        editText.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
                // Step 5: Check if the touch event is within the drawable end bounds
                val drawableEnd = editText.compoundDrawablesRelative[2]
                if (drawableEnd != null && motionEvent.action == MotionEvent.ACTION_UP) {
                    val bounds: Rect = drawableEnd.bounds
                    val x = motionEvent.x.toInt()

                    // Step 6: Handle the click event
                    if (x >= view.width - view.paddingRight - bounds.width()) {
                        val cursorPosition = editText.selectionStart
                        // Step 7: Toggle the password visibility
                        val isPasswordVisible = editText.transformationMethod == PasswordTransformationMethod.getInstance()
                        if (isPasswordVisible) {
                            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                        } else {
                            editText.transformationMethod = PasswordTransformationMethod.getInstance()
                        }

                        // Step 8: Change the visibility icon based on the password visibility state
                        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.password_visibility,
                            0
                        )
                        editText.setSelection(cursorPosition)
                        return true
                    }
                }
                return false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}