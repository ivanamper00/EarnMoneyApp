package com.vietkiem.kimtinviinthoicabn.earn.utils

import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.earn.fragment.home.ButtonModel

object Asset {

    const val EARN = "Kiếm"
    const val SAVE = "Cứu"
    const val CRYPTO = "Tiền điện tử"
    const val SELL = "Bán"

    var buttons = listOf(
        ButtonModel(EARN, R.drawable.ic_cash),
        ButtonModel(SAVE, R.drawable.ic_bank),
        ButtonModel(CRYPTO, R.drawable.ic_crypto),
        ButtonModel(SELL, R.drawable.ic_coin),
    )

    var banner = listOf(
        R.drawable.ic_banner,
        R.drawable.ic_banner_2
    )

}

enum class ButtonEnum(var type: String, var title: String){
    EARN("vietnam_earn_money", Asset.EARN),
    SAVE("vietnam_earn_money2", Asset.SAVE),
    CRYPTO("vietnam_tron_mining", Asset.CRYPTO),
    SELL("vietnam_earn_selling", Asset.SELL)
}