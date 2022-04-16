package com.vietkiem.kimtinviinthoicabn.common.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import com.vietkiem.kimtinviinthoicabn.R

class DialogLoading(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        setCancelable(false)
    }

    override fun onStart() {
        super.onStart()
        window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawableResource(android.R.color.transparent);
    }
}