package com.vietkiem.kimtinviinthoicabn.earn.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.Content
import com.vietkiem.kimtinviinthoicabn.common.base.BaseActivity
import com.vietkiem.kimtinviinthoicabn.common.base.BaseFragment
import com.vietkiem.kimtinviinthoicabn.common.binding.viewBinding
import com.vietkiem.kimtinviinthoicabn.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    private val args : DetailsFragmentArgs by navArgs()

    private val navigator by lazy {
        requireActivity() as BaseActivity.AppNavigator
    }

    private val dataItem by lazy {
        Gson().fromJson(args.data, Content::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                navigator.navigateToHome()
            }
        })

        setupViews()
    }

    private fun setupViews() {
        binding.title.text = dataItem.title
        binding.description.text = HtmlCompat.fromHtml(dataItem.description ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}