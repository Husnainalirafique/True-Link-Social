package com.example.truelinksocial.ui.after_Sign_up_onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOnboardingChooseAvatarBinding
import com.example.truelinksocial.ui.after_Sign_up_onboarding.adapter.AvatarRecyclerViewAdapter
import com.example.truelinksocial.ui.after_Sign_up_onboarding.data.AvatarRecyclerViewData

class OnboardingChooseAvatarFragment :Fragment(),AvatarRecyclerViewAdapter.OnImageClick{
    private lateinit var binding: FragmentOnboardingChooseAvatarBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding_choose_avatar, container, false)

        //functions
        handlingAvatarRecyclerView()
        handleBackButton()
        return binding.root

    }

    //handle button click
    private fun handleBtnClick(){

    }
    //Handling the back button
    private fun handleBackButton(){
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    //setting recycler view
    private fun handlingAvatarRecyclerView(){
        val recyclerView = binding.avatarRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        //Data
        val imgList = arrayListOf(
            AvatarRecyclerViewData(R.drawable.avatar2),
            AvatarRecyclerViewData(R.drawable.avatar3),
            AvatarRecyclerViewData(R.drawable.avatar4),
            AvatarRecyclerViewData(R.drawable.avatar5),
            AvatarRecyclerViewData(R.drawable.avatar6),
            )
        //setting Adapter
        recyclerView.adapter = AvatarRecyclerViewAdapter(imgList,this)
    }
     override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

    override fun onClick(imgres: AvatarRecyclerViewData) {
        binding.setimg.setImageResource(imgres.image)
        binding.setimg.visibility = View.VISIBLE
        binding.btnFindYourMatch.isEnabled = true
        binding.btnFindYourMatch.alpha = 1.0f
    }


}