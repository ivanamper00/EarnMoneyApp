package com.vietkiem.kimtinviinthoicabn.common.base

import androidx.appcompat.app.AppCompatActivity
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.Content
import com.vietkiem.kimtinviinthoicabn.common.ui.DialogLoading
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BaseActivity: JumpActivity(){

    private val loading by lazy {
        DialogLoading(this)
    }
    
    fun showLoading(isLoading: Boolean){
        if(isLoading) loading.show()
        else loading.dismiss()
    }


    interface AppNavigator {
        fun onDetailsNavigate(data: Content)
        fun navigateToHome()
        fun jumpToWebView(domain: Int)
    }
}