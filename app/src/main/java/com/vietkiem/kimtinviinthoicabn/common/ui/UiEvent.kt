package com.vietkiem.kimtinviinthoicabn.common.ui

open class UiEvent {
    data class Loading(val isloading: Boolean): UiEvent()
    data class Error(val error: Exception): UiEvent()
}