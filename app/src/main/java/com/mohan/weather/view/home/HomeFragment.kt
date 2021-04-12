package com.mohan.weather.view.home

import android.os.Bundle
import com.mohan.weather.R
import com.mohan.weather.core.BaseFragment
import com.mohan.weather.databinding.FragmentHomeBinding

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    private lateinit var binding :FragmentHomeBinding
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}