package com.vietkiem.kimtinviinthoicabn.earn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dakulangsakalam.customwebview.presentation.ui.jump.webview.WebViewActivity
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.common.base.BaseActivity
import com.vietkiem.kimtinviinthoicabn.common.binding.viewBinding
import com.vietkiem.kimtinviinthoicabn.databinding.ActivityCustomWebViewBinding

class CustomWebView : BaseActivity() {

    private val binding by viewBinding(ActivityCustomWebViewBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val url = intent.getStringExtra(WebViewActivity.URL)
        binding.customWeb.loadUrl(url ?: "")


    }

    companion object{
        const val URL = "url"

        fun createIntent(context: Context): Intent = Intent(context, CustomWebView::class.java)
        fun createIntent(context: Context, url: String): Intent {
            val intent = Intent(context, CustomWebView::class.java)
            intent.putExtra(URL, url);
            return intent
        }
    }
}