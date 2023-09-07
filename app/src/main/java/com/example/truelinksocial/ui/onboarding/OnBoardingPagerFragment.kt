package com.example.truelinksocial.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.truelinksocial.R
import com.example.truelinksocial.databinding.FragmentOnBoardingPagerBinding
import com.example.truelinksocial.ui.onboarding.adapter.OnBoardingAdapter

class OnBoardingPagerFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingPagerBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding_pager, container, false)

        //view pager2
        connectingViewPager()

        //Dots Indicator page change listner
        viewPagerPageChangeListner()
        return binding.root
    }

    private fun connectingViewPager(){
        // list of on boarding fragments to pass to adapter
        val fragmentList = arrayListOf( Onboarding1Fragment(), Onboarding2Fragment(), Onboarding3Fragment())

        //setting the adapter to viewpager
        val adapter = OnBoardingAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
    }

    private fun viewPagerPageChangeListner(){
        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                changeColor()
                super.onPageScrollStateChanged(state)
            }

        })
    }

    internal fun changeColor() {
        when (binding.viewpager.currentItem) {
            0 -> {
                binding.onBoardingPagerFragmentDotImg1.setBackgroundColor(resources.getColor(R.color.primary_color,null))
                binding.onBoardingPagerFragmentDotImg2.setBackgroundColor(resources.getColor(R.color.inActive,null))
                binding.onBoardingPagerFragmentDotImg3.setBackgroundColor( resources.getColor(R.color.inActive,null))
            }
            1 -> {
                binding.onBoardingPagerFragmentDotImg1.setBackgroundColor(resources.getColor(R.color.inActive,null))
                binding.onBoardingPagerFragmentDotImg2.setBackgroundColor(resources.getColor(R.color.primary_color,null))
                binding.onBoardingPagerFragmentDotImg3.setBackgroundColor(resources.getColor(R.color.inActive,null ))
            }

            2 -> {
                binding.onBoardingPagerFragmentDotImg1.setBackgroundColor(resources.getColor(R.color.inActive,null))
                binding.onBoardingPagerFragmentDotImg2.setBackgroundColor(resources.getColor(R.color.inActive,null))
                binding.onBoardingPagerFragmentDotImg3.setBackgroundColor(resources.getColor(R.color.primary_color,null ))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}