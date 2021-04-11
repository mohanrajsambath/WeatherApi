package com.mohan.weather.viewmodel

import androidx.lifecycle.viewModelScope
import com.mohan.weather.data.remote.repository.WeatherRepository
import com.sathish.carmap.base.BaseViewModel
import kotlinx.coroutines.launch
import com.mohan.weather.data.remote.repository.Result
import com.mohan.weather.model.WeatherInfoModel

class WeatherViewModel(private val repository: WeatherRepository) :BaseViewModel(){
    private  var weatherList: MutableList<WeatherInfoModel> = mutableListOf()
    fun getWeatherData() {
        viewModelScope.launch {
            when(val result = repository.getWeatherList()){
                is Result.Success -> {
                    val data = result.data
                }
                is Result.Error -> {
                   //
                }
            }
        }

    }
}