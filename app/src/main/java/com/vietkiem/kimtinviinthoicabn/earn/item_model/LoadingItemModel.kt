package com.vietkiem.kimtinviinthoicabn.earn.item_model


import android.view.View
import android.widget.ProgressBar
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.databinding.ItemLoadingBinding


@EpoxyModelClass(layout = R.layout.item_loading)
abstract class LoadingItemModel : EpoxyModelWithHolder<LoadingItemModel.Holder>() {

    override fun bind(holder: Holder) {
        val progressBar = holder.binding.progressBar as ProgressBar
        val threeBounce: Sprite = ThreeBounce()
        progressBar.indeterminateDrawable = threeBounce
    }

    class Holder : EpoxyHolder() {
        lateinit var binding : ItemLoadingBinding
        override fun bindView(itemView: View) {
            binding = ItemLoadingBinding.bind(itemView)
        }
    }
}
