package com.vietkiem.kimtinviinthoicabn.earn.fragment.home

import android.net.Uri
import com.airbnb.epoxy.EpoxyController
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs
import com.google.gson.Gson
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.Content
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.earn.item_model.*
import com.vietkiem.kimtinviinthoicabn.earn.utils.ButtonEnum

class BottomSheetController(private val listener: Listener): EpoxyController() {

    private var dataContent: DataResponse? = null

    private var enumType: ButtonEnum? = ButtonEnum.EARN

    private var contentTitle : String? = ""

    private var isLoading = false

    override fun buildModels() {

        if(isLoading){
           for (i in 0..4){
               loadingItem {
                   id(LoadingItemModel::class.simpleName)
               }
           }
            return
        }

        contentTitleItem {
            id(ContentTitleItemModel::class.simpleName)
            title(this@BottomSheetController.contentTitle)
        }

        dataContent?.contents?.forEach{
            writeLogs(it.title ?: "")
            writeLogs(Uri.decode(it.assets))
            dataItem {
                id("${this@BottomSheetController.contentTitle}${it.id}")
                title(it.title)
                description(it.description)
                url(it.icon)
                onClick { _ -> this@BottomSheetController.listener.onDataItemClick(it) }
            }
        }

    }

    fun buildData(data: DataResponse, buttonEnum: ButtonEnum) {
        dataContent = data
        enumType = buttonEnum
        contentTitle = buttonEnum.title
        writeLogs(Gson().toJson(data))
        requestModelBuild()
    }

    fun setIsLoading(isLoading: Boolean){
        this.isLoading = isLoading
        requestModelBuild()
    }

    interface Listener{
        fun onDataItemClick(data: Content)
    }
}