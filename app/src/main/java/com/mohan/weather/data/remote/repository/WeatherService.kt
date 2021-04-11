package com.mohan.weather.data.remote.repository

import com.mohan.weather.model.WeatherInfoModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather?")
    suspend fun getWeatherInfo(
        @Query("q") mcity: String,
        @Query("units") mUnit: String,
        @Query("appid") mKey: String
    ): Response<WeatherInfoModel>
}