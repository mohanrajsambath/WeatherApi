package com.mohan.weather.di

import com.google.android.gms.location.LocationRequest
import com.mohan.weather.data.remote.repository.WeatherRepository
import com.mohan.weather.data.remote.repository.WeatherRepositoryImpl
import com.mohan.weather.data.remote.repository.WeatherService
import com.mohan.weather.utils.Constants.BASE_URL
import com.mohan.weather.viewmodel.WeatherViewModel
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single {  provideRetrofit(get())}
    single {  provideLocationRequest()}

    factory {  okHttpClient()}
    factory { WeatherService(get()) }
}
val viewModelModule = module {
    viewModel {WeatherViewModel(get())}
    factory { WeatherRepositoryImpl(get()) }.bind(WeatherRepository::class)
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


fun okHttpClient(): OkHttpClient {
    val interceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor()
    interceptor!!.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(interceptor)
        .build()
}


fun  WeatherService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

fun provideLocationRequest(): LocationRequest? {
    return LocationRequest.create()
        .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
        .setInterval(1000)
}