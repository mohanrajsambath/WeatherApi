package com.mohan.weather.data.repo

import android.util.Log
import com.mohan.weather.model.WeatherInfoModel

class CityWeatherRepositoryImpl(private val weatherService: WeatherService) : CityWeatherRepository {
    override suspend fun getWeatherList(): Result<WeatherInfoModel> {
        try {
            val response = weatherService.getWeatherInfo("Coimbatore", "metric", "fae7190d7e6433ec3a45285ffcf55c86")
            if (response.isSuccessful) {
                return Result.Success(response.body()!!)
                Log.e("CityWeatherRepoImpl","---=>"+response.body()!!.toString())
            }
            return Result.Error("Doctor List Ended")
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        }
    }
}