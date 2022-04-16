package com.vietkiem.kimtinviinthoicabn.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vietkiem.kimtinviinthoicabn.common.utils.showToast

abstract class BaseFragment(private var layoutRes: Int): Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    fun onBackPressed(){
        requireActivity().onBackPressed()
    }

    fun showToast(message: String){
        requireContext().showToast(message)
    }

    fun showLoading(isLoading: Boolean){
        (requireActivity() as BaseActivity).showLoading(isLoading)
    }
}