package com.mohan.weather.data.repo

import com.mohan.weather.model.WeatherInfoModel

interface WeatherRepository {
    suspend fun getWeatherList():Result<WeatherInfoModel>
}