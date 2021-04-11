package com.mohan.weather.core

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T>(
    @LayoutRes private val layoutResId: Int? = null
) :
    AppCompatActivity() where T : ViewDataBinding {

    abstract fun onActivityCreated(dataBinder: T)


    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
    }

    private fun initial() {
        this@BaseActivity.layoutResId?.let { layoutId ->
            val dataBinder = DataBindingUtil.setContentView<T>(this@BaseActivity, layoutId)
            this@BaseActivity.onActivityCreated(dataBinder)
        }
    }

    protected fun showMessage(message: String) {
        Toast.makeText(this@BaseActivity, message, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyBoard() {
        val inputManager: InputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            this.currentFocus!!.windowToken,
            InputMethodManager.SHOW_FORCED
        )
    }


}