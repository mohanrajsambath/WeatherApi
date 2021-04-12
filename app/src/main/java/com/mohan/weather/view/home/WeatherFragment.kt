package com.mohan.weather.view.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mohan.weather.R
import com.mohan.weather.core.BaseFragment
import com.mohan.weather.databinding.FragmentCityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment: BaseFragment<FragmentCityBinding>() {
    private val weatherViewModel: WeatherViewModel by viewModel()
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
        weatherViewModel._weatherInfo.observe(viewLifecycleOwner, Observer {
            binding.apply {
                this.txtViewCity.text = it.name
                this.txtViewDate.text = getDateString(it.date)
                this.txtViewTemp.text =it.main.temp.toString()+"°C"
                this.txtViewTempMin.text ="Min Temp: "+it.main.tempMin.toString()+"°C"
                this.txtViewTempMax.text ="Max Temp: "+it.main.tempMax.toString()+"°C"
                this.txtViewSunrisetime.text=getTimeString(it.sys.sunrise.toLong())
                this.txtViewSunsetime.text=getTimeString(it.sys.sunset.toLong())
                this.txtViewPressureTemp.text=it.main.pressure.toString()+" hpa"
                this.txtViewHumidityTemp.text=it.main.humidity.toString()+" %"
                //this.txtViewDate.text = it.coord.lon.toString()
            }
        })
    }

    fun getDateString(time: Long) : String = simpleDateFormat.format(time * 1000L)
    fun getTimeString(time: Long) : String = simpleTimeFormat.format(Date(time * 1000))

}