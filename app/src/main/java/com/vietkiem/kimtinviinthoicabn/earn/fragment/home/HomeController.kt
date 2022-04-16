package com.vietkiem.kimtinviinthoicabn.earn.fragment.home

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.earn.item_model.HomeButtonItemModel_
import com.vietkiem.kimtinviinthoicabn.earn.item_model.bannerItem
import com.vietkiem.kimtinviinthoicabn.earn.item_model.homeButtonItem
import com.vietkiem.kimtinviinthoicabn.earn.utils.Asset
import com.vietkiem.kimtinviinthoicabn.earn.utils.ButtonEnum

class HomeController(private val listener: Listener): EpoxyController() {

    var buttons = Asset.buttons

    var banners = Asset.banner

    override fun buildModels() {

        val contentItem = buttons.map {
            HomeButtonItemModel_()
                .id(it.title)
                .title(it.title)
                .logo(it.logo)
                .onClick { _ ->
                    listener.onButtonListener(it.title)
                }
        }

        carousel {
            id("carousel")
            models(contentItem)
            numViewsToShowOnScreen(4F)
            paddingDp(16)
        }

        banners.forEach {
            bannerItem {
                id(it)
                resource(it)
                onClick { _-> this@HomeController.listener.onButtonListener(it.toString()) }
            }
        }

    }

    interface Listener{
        fun onButtonListener(id: String)
    }
}