package com.mohan.weather.data.remote.repository

import com.mohan.weather.model.WeatherInfoModel

interface WeatherRepository {
    suspend fun getWeatherList():Result<WeatherInfoModel>
}