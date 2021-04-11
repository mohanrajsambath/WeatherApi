package com.mohan.weather.di

import com.google.android.gms.location.LocationRequest
import com.mohan.weather.data.repo.WeatherRepository
import com.mohan.weather.data.repo.WeatherRepositoryImpl
import com.mohan.weather.data.repo.WeatherService
import com.mohan.weather.utils.Constants.BASE_URL
import com.mohan.weather.view.home.WeatherViewModel
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit


val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
    factory { WeatherRepositoryImpl(get()) }.bind(WeatherRepository::class)
}

