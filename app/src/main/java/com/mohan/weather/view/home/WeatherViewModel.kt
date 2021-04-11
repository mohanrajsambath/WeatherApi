package com.mohan.weather.view.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mohan.weather.data.repo.Result
import com.mohan.weather.data.repo.WeatherRepository
import com.mohan.weather.model.WeatherInfoModel
import com.mohan.weather.core.BaseViewModel
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : BaseViewModel(){

    private  var weatherInfo: MutableLiveData<WeatherInfoModel> = MutableLiveData()
    val _weatherInfo: MutableLiveData<WeatherInfoModel> = weatherInfo
    private  var error: MutableLiveData<String> = MutableLiveData()
    val _errorInfo: MutableLiveData<String> = error
    init{
        getWeatherData()
    }


    fun getWeatherData() {
        viewModelScope.launch {
            when(val result = repository.getWeatherList()){
                is Result.Success -> {
                    weatherInfo.value=result.data
                    Log.e("Weather Result---=>","$weatherInfo.value")
                }
                is Result.Error -> {
                    error.value=result.data.toString()
                }
            }
        }

    }
}