package com.vietkiem.kimtinviinthoicabn.earn.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vietkiem.kimtinviinthoicabn.common.model.Response
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.app.domain.model.Request
import com.vietkiem.kimtinviinthoicabn.app.domain.use_case.UseCase
import com.vietkiem.kimtinviinthoicabn.common.ui.UiEvent
import com.vietkiem.kimtinviinthoicabn.earn.utils.ButtonEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val useCase: UseCase
): ViewModel() {

    private val _uiEvent = MutableLiveData<UiEvent>()
    val uiEvent: LiveData<UiEvent> get() = _uiEvent

    fun getData(button: ButtonEnum){
        val param = Request(
            button.type,
            "data"
        )
        _uiEvent.value = UiEvent.Loading(true)
        viewModelScope.launch (CoroutineExceptionHandler { _, throwable ->
            _uiEvent.postValue(UiEvent.Loading(false))
            _uiEvent.postValue(UiEvent.Error(throwable as Exception))
        }) {
            val response = useCase.getData(param)
            if(response.isSuccessful){
                when(button){
                    ButtonEnum.EARN -> _uiEvent.value = HomeEvent.EarnSuccess(response.body()!!)
                    ButtonEnum.SAVE -> _uiEvent.value = HomeEvent.SaveSuccess(response.body()!!)
                    ButtonEnum.CRYPTO -> _uiEvent.value = HomeEvent.CryptoSuccess(response.body()!!)
                    ButtonEnum.SELL -> _uiEvent.value = HomeEvent.SellSuccess(response.body()!!)
                }
            }
            _uiEvent.postValue(UiEvent.Loading(false))
        }
    }
}