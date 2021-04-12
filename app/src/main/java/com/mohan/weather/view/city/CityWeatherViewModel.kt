package com.mohan.weather.view.city

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mohan.weather.core.BaseViewModel
import com.mohan.weather.data.repo.CityWeatherRepository
import com.mohan.weather.data.repo.Result
import com.mohan.weather.model.WeatherInfoModel
import kotlinx.coroutines.launch

class CityWeatherViewModel(private val repositoryCity: CityWeatherRepository) : BaseViewModel(){

    private  var weatherInfo: MutableLiveData<WeatherInfoModel> = MutableLiveData()
    val _weatherInfo: MutableLiveData<WeatherInfoModel> = weatherInfo
    private  var error: MutableLiveData<String> = MutableLiveData()
    val _errorInfo: MutableLiveData<String> = error
    init{
        getWeatherData()
    }


    fun getWeatherData() {
        viewModelScope.launch {
            when(val result = repositoryCity.getWeatherList()){
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