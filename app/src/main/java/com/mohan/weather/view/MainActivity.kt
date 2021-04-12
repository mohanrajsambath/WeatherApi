package com.mohan.weather.view

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mohan.weather.R
import com.mohan.weather.core.BaseActivity
import com.mohan.weather.databinding.ActivityMainBinding
import com.mohan.weather.view.city.CityWeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val cityWeatherViewModel: CityWeatherViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding


    private fun setUpViewModelObserver() {
        //adds the new set of results to the adapter list
//        weatherViewModel.doctorList.observe(this, Observer<List<WeatherInfoModel>> {
//        })
    }

    override fun onActivityCreated(dataBinder: ActivityMainBinding) {
        binding=dataBinder
        cityWeatherViewModel.getWeatherData()
        setUpViewModelObserver()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController( binding.includeLayout.bottomNav, navController)
        /*binding.button.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked me", Toast.LENGTH_SHORT).show()
            weatherViewModel.getWeatherData()
        }*/
    }
}