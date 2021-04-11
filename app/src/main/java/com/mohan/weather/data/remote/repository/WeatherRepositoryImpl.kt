package com.mohan.weather.data.remote.repository

import android.util.Log
import com.mohan.weather.model.WeatherInfoModel

class WeatherRepositoryImpl(private val doctorService: WeatherService) : WeatherRepository {
    override suspend fun getWeatherList(): Result<WeatherInfoModel> {
        try {
            val response = doctorService.getWeatherInfo("Coimbatore", "", "fae7190d7e6433ec3a45285ffcf55c86")
            if (response.isSuccessful) {
                return Result.Success(response.body()!!)
                Log.e("WeatherRepositoryImpl","---=>"+response.body()!!.toString())
            }
            return Result.Error("Doctor List Ended")
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        }
    }
}