package com.vietkiem.kimtinviinthoicabn.common.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

@BindingAdapter("android:backgroundResource")
fun backgroundResource(view: View, @DrawableRes uri: Int){
    view.setBackgroundResource(uri)
}

@BindingAdapter("android:uriSrc")
fun uriSrc(view: ImageView, uri: String){
    try {
        if(view.context == null) return
        Glide.with(view.context)
            .load(uri)
            .apply(RequestOptions().format(DecodeFormat.PREFER_RGB_565))
            .into(view)
    }catch(e: Exception){}
}

