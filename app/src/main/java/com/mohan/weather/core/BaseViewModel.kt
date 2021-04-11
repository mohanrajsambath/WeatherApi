
package com.mohan.weather.core
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val errorMessage: MutableLiveData<String> = MutableLiveData()

}