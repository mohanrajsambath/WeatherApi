package com.mohan.weather.view.city

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mohan.weather.R
import com.mohan.weather.core.BaseFragment
import com.mohan.weather.databinding.FragmentCityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class CityWeatherFragment: BaseFragment<FragmentCityBinding>() {
    private val cityWeatherViewModel: CityWeatherViewModel by viewModel()
    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.ENGLISH)
    private val simpleTimeFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)

    private lateinit var binding: FragmentCityBinding
    override fun getLayoutId(): Int=R.layout.fragment_city

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding=getDataBinding()

        setViewModelObserver()

    }

    @SuppressLint("SetTextI18n")
    private fun setViewModelObserver(){
        cityWeatherViewModel._weatherInfo.observe(viewLifecycleOwner, Observer { weatherInof ->
            binding.apply {
                this.txtViewCity.text = weatherInof.name
                this.txtViewDate.text  = weatherInof.date.getDateString()
                this.txtViewTemp.text =weatherInof.main.temp.toString()+"°C"
                this.txtViewTempMin.text ="Min Temp: "+weatherInof.main.tempMin.toString()+"°C"
                this.txtViewTempMax.text ="Max Temp: "+weatherInof.main.tempMax.toString()+"°C"
                this.txtViewSunrisetime.text=weatherInof.sys.sunrise.toLong().getTimeString()
                this.txtViewSunsetime.text=weatherInof.sys.sunset.toLong().getTimeString()
                this.txtViewPressureTemp.text=weatherInof.main.pressure.toString()+" hpa"
                this.txtViewHumidityTemp.text=weatherInof.main.humidity.toString()+" %"
                //this.txtViewDate.text = it.coord.lon.toString()
            }
        })
    }


    //extension function
    private fun Long.getDateString() : String = simpleDateFormat.format(this * 1000L)
    private fun Long.getTimeString() : String = simpleTimeFormat.format(Date(this * 1000))

}