package com.vietkiem.kimtinviinthoicabn.earn.fragment.home

import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.common.ui.UiEvent

class HomeEvent: UiEvent() {
    data class EarnSuccess(val data: DataResponse): UiEvent()
    data class SaveSuccess(val data: DataResponse): UiEvent()
    data class CryptoSuccess(val data: DataResponse): UiEvent()
    data class SellSuccess(val data: DataResponse): UiEvent()
}