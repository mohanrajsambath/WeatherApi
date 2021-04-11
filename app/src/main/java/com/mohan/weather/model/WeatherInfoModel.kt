////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2021.                                                         /
// Project Name : Weather                                                      /
// Module Name : Weather.app                                                   /
// Created by : mohan                                                          /
// Created on : 9/4/21 2:34 AM                                                 /
// Updated on : 9/4/21 2:33 AM                                                 /
// File Name : WeatherInfoModel.kt                                             /
// Class Name : WeatherInfoModel.kt                                            /
//                                                                             /
////////////////////////////////////////////////////////////////////////////////

package com.mohan.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherInfoModel(
    /*Json objects are searlized by using GSON serialization*/
    @SerializedName("base")
    val base: String = "", // stations
    @SerializedName("clouds")
    val clouds: Clouds = Clouds(),
    @SerializedName("cod")
    val cod: Int = 0, // 200
    @SerializedName("coord")
    val coord: Coord = Coord(),
    @SerializedName("dt")
    val dt: Int = 0, // 1571235600
    @SerializedName("id")
    val id: Int = 0, // 2950159
    @SerializedName("main")
    val main: Main = Main(),
    @SerializedName("name")
    val name: String = "", // Berlin
    @SerializedName("rain")
    val rain: Rain = Rain(),
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("timezone")
    val timezone: Int = 0, // 7200
    @SerializedName("visibility")
    val visibility: Int = 0, // 10000
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("wind")
    val wind: Wind = Wind()

)

data class Clouds(
    @SerializedName("all")
    val all: Int = 0 // 90
)
data class Coord(
    @SerializedName("lat")
    val lat: Double = 0.0, // 52.52
    @SerializedName("lon")
    val lon: Double = 0.0 // 13.39
)


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

data class Rain(
    @SerializedName("1h")
    val h: Double = 0.0 // 0.93
)

data class Sys(
    @SerializedName("country")
    val country: String = "", // DE
    @SerializedName("id")
    val id: Int = 0, // 1275
    @SerializedName("sunrise")
    val sunrise: Int = 0, // 1571203961
    @SerializedName("sunset")
    val sunset: Int = 0, // 1571242269
    @SerializedName("type")
    val type: Int = 0 // 1
)

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

data class Wind(
    @SerializedName("deg")
    val deg: Int = 0, // 240
    @SerializedName("speed")
    val speed: Double = 0.0 // 7.2
)
