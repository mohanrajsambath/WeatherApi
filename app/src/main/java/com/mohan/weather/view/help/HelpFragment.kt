package com.mohan.weather.view.help

import android.os.Bundle
import com.mohan.weather.R
import com.mohan.weather.core.BaseFragment
import com.mohan.weather.databinding.FragmentHelpBinding

class HelpFragment:BaseFragment<FragmentHelpBinding>() {
    private lateinit var binding:FragmentHelpBinding
    override fun getLayoutId(): Int = R.layout.fragment_help

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}