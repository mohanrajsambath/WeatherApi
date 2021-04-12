package com.mohan.weather.data.repo

import com.mohan.weather.model.WeatherInfoModel

interface CityWeatherRepository {
    suspend fun getWeatherList():Result<WeatherInfoModel>
}