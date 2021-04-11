package com.mohan.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mohan.weather.R
import com.mohan.weather.databinding.ActivityMainBinding
import com.mohan.weather.model.WeatherInfoModel
import com.mohan.weather.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked me", Toast.LENGTH_SHORT).show()
            weatherViewModel.getWeatherData()
        }
        setUpViewModelObserver()
    }

    private fun setUpViewModelObserver() {
        //adds the new set of results to the adapter list
//        weatherViewModel.doctorList.observe(this, Observer<List<WeatherInfoModel>> {
//
//        })
    }
}