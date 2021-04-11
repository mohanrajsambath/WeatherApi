package com.mohan.weather.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String = "", // light rain
    @SerializedName("icon")
    val icon: String = "", // 10d
    @SerializedName("id")
    val id: Int = 0, // 500
    @SerializedName("main")
    val main: String = "" // Rain
)