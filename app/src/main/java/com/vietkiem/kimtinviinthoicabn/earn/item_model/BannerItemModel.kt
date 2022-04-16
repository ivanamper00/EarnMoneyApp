package com.vietkiem.kimtinviinthoicabn.earn.item_model

import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes
import com.airbnb.epoxy.*
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.databinding.ItemBannerBinding

@EpoxyModelClass(layout = R.layout.item_banner)
abstract class BannerItemModel : EpoxyModelWithHolder<BannerItemModel.Holder>() {


    @EpoxyAttribute
    @LayoutRes var resource: Int = 0

    @EpoxyAttribute
    lateinit var onClick: View.OnClickListener

    override fun bind(holder: Holder) {
        super.bind(holder)

        holder.binding.root.setOnClickListener(onClick)

        holder.binding.apply {
            banner.setImageResource(resource)
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: ItemBannerBinding

        override fun bindView(itemView: View) {
            binding = ItemBannerBinding.bind(itemView)
        }
    }
}