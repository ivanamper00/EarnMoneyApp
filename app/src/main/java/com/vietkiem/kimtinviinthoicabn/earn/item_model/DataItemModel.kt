package com.vietkiem.kimtinviinthoicabn.earn.item_model

import android.net.Uri
import android.view.View
import androidx.core.text.HtmlCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.databinding.ItemmodelHeaderTitleBinding
import javax.xml.transform.ErrorListener

@EpoxyModelClass(layout = R.layout.itemmodel_header_title)
abstract class DataItemModel : EpoxyModelWithHolder<DataItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var description: String

    @EpoxyAttribute
    lateinit var url: String

    @EpoxyAttribute
    lateinit var onClick: View.OnClickListener

    override fun bind(holder: Holder) {
        super.bind(holder)
        val context = holder.binding.root.context
        holder.binding.title.text = title
        holder.binding.description.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        holder.binding.root.setOnClickListener(onClick)
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_app_logo)
            .into(holder.binding.shapeableImageView)
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: ItemmodelHeaderTitleBinding

        override fun bindView(itemView: View) {
            binding = ItemmodelHeaderTitleBinding.bind(itemView)
        }
    }
}
