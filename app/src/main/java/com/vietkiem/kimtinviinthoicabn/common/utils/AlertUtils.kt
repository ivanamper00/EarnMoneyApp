package com.vietkiem.kimtinviinthoicabn.common.utils

import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper
import android.content.DialogInterface

class AlertUtils {
    companion object{

        fun alertExit(context: Context, onClick: DialogInterface.OnClickListener): AlertDialog{
            return AlertDialog.Builder(context)
                .setMessage("Are you sure you want to exit?")
                .setTitle("Exit")
                .setPositiveButton("Exit", onClick)
                .setNegativeButton("Cancel", onClick)
                .create()
        }

        fun alertNoContent(context: Context): AlertDialog {
            return AlertDialog.Builder(context)
                .setMessage("This content is not available right now. Please try again later.")
                .setTitle("Content Not Available")
                .setPositiveButton("Ok"){ d, _ -> d.dismiss()}
                .create()
        }
    }
}