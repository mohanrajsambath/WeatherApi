package com.mohan.weather.di

import com.mohan.weather.data.repo.CityWeatherRepository
import com.mohan.weather.data.repo.CityWeatherRepositoryImpl
import com.mohan.weather.view.city.CityWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CityWeatherViewModel(get()) }
    factory { CityWeatherRepositoryImpl(get()) }.bind(CityWeatherRepository::class)
}

