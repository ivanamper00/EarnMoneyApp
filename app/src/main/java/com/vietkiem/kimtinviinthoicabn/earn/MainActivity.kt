package com.vietkiem.kimtinviinthoicabn.earn

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpType
import com.dakulangsakalam.customwebview.presentation.ui.jump.webview.WebViewActivity
import com.google.gson.Gson
import com.vietkiem.kimtinviinthoicabn.common.base.BaseActivity
import com.vietkiem.kimtinviinthoicabn.common.binding.viewBinding
import com.vietkiem.kimtinviinthoicabn.common.utils.AlertUtils
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.Content
import com.vietkiem.kimtinviinthoicabn.databinding.ActivityMainBinding
import com.vietkiem.kimtinviinthoicabn.earn.fragment.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity(), BaseActivity.AppNavigator {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
    }

    private val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if(navHostFragment.childFragmentManager.backStackEntryCount == 0) {
            AlertUtils.alertExit(this){ p0, p1 ->
                when(p1){
                    DialogInterface.BUTTON_POSITIVE -> super.onBackPressed()
                    else ->  p0.dismiss()
                }
            }.show()
        }else super.onBackPressed()
    }

    companion object{
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun onDetailsNavigate(data: Content) {
        val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(Gson().toJson(data))
        navController.navigate(direction)


    }

    override fun navigateToHome() {
        navController.navigate(R.id.action_detailsFragment_to_homeFragment)
    }

    override fun jumpToWebView(domain: Int) {
        val url = if(domain == 1) "file:///android_asset/index.html" else "file:///android_asset/index2.html"
        startActivity(CustomWebView.createIntent(this, url))
    }
}