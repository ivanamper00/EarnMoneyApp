package com.vietkiem.kimtinviinthoicabn.earn.item_model


import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.databinding.ItemHomeButtonsBinding


@EpoxyModelClass(layout = R.layout.item_home_buttons)
abstract class HomeButtonItemModel : EpoxyModelWithHolder<HomeButtonItemModel.Holder>() {

    @EpoxyAttribute
    var title: String? = null

    @EpoxyAttribute
    var logo: Int? = null

    @EpoxyAttribute
    var onClick: View.OnClickListener? = null

    override fun bind(holder: Holder) {
        holder.binding.title.text = title
        holder.binding.logo.setImageResource(logo ?: 0)
        holder.binding.root.setOnClickListener(onClick)
    }

    class Holder : EpoxyHolder() {
        lateinit var binding : ItemHomeButtonsBinding
        override fun bindView(itemView: View) {
            binding = ItemHomeButtonsBinding.bind(itemView)
        }
    }
}
