package com.mohan.weather.view.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mohan.weather.R
import com.mohan.weather.core.BaseFragment
import com.mohan.weather.databinding.FragmentCityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment: BaseFragment<FragmentCityBinding>() {
    private val weatherViewModel: WeatherViewModel by viewModel()

    private lateinit var binding: FragmentCityBinding
    override fun getLayoutId(): Int=R.layout.fragment_city

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding=getDataBinding()

        setViewModelObserver()

    }

    private fun setViewModelObserver(){
        weatherViewModel._weatherInfo.observe(viewLifecycleOwner, Observer {

            binding.apply {
                this.txtViewCity.text = it.name
                this.txtViewDate.text = it.coord.lat.toString()
            }
        })
    }

}