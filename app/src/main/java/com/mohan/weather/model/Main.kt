package com.mohan.weather.model


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("humidity")
    val humidity: Int = 0, // 93
    @SerializedName("pressure")
    val pressure: Int = 0, // 1010
    @SerializedName("temp")
    val temp: Double = 0.0, // 12.12
    @SerializedName("temp_max")
    val tempMax: Double = 0.0, // 13.33
    @SerializedName("temp_min")
    val tempMin: Double = 0.0 // 11.11
)