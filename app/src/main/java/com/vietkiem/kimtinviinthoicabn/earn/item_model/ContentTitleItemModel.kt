package com.vietkiem.kimtinviinthoicabn.earn.item_model


import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.databinding.ItemContentTitleBinding
import com.vietkiem.kimtinviinthoicabn.databinding.ItemHomeButtonsBinding


@EpoxyModelClass(layout = R.layout.item_content_title)
abstract class ContentTitleItemModel : EpoxyModelWithHolder<ContentTitleItemModel.Holder>() {

    @EpoxyAttribute
    var title: String? = null

    override fun bind(holder: Holder) {
        holder.binding.title.text = title
    }

    class Holder : EpoxyHolder() {
        lateinit var binding : ItemContentTitleBinding
        override fun bindView(itemView: View) {
            binding = ItemContentTitleBinding.bind(itemView)
        }
    }
}
