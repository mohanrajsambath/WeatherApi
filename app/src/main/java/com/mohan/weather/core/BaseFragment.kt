package com.mohan.weather.core
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


abstract class BaseFragment<DataBinding : ViewDataBinding> : Fragment() {

    private val KEY_ARG = "arg"
    private val REQUEST_CODE = 100
    private lateinit var dataBinding: DataBinding

    abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View is created using layout Id
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ViewModel is set as Binding Variable
        dataBinding.apply {
            lifecycleOwner = this@BaseFragment
        }
    }

    fun getDataBinding() = dataBinding

    protected fun navigateTo(@IdRes actionId: Int, arg: Parcelable? = null) {

        val bundle = arg?.let { Bundle().apply { putParcelable(KEY_ARG, it) } }
        findNavController().navigate(actionId, bundle)
    }

    fun showMessage(message: String) {
        activity?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT)
                .show()
        }

    }

    fun hideKeyBoard() {
        val inputManager: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            requireActivity().currentFocus!!.windowToken,
            InputMethodManager.SHOW_FORCED
        )
    }

    fun showDialog(displayMessage:String) {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(displayMessage)
        dialogBuilder.setPositiveButton("Done",
            DialogInterface.OnClickListener { _, _ -> })
        val b = dialogBuilder.create()
        b.show()
    }
}