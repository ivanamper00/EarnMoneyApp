package com.vietkiem.kimtinviinthoicabn.common.utils

import android.content.Context
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

fun clipToBackground(view: View) {
    view.outlineProvider = ViewOutlineProvider.BACKGROUND
    view.clipToOutline = true
}

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT)

