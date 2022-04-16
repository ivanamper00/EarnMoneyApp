package com.vietkiem.kimtinviinthoicabn.earn.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.vietkiem.kimtinviinthoicabn.common.base.BaseFragment
import com.vietkiem.kimtinviinthoicabn.R
import com.vietkiem.kimtinviinthoicabn.app.domain.dto.Content
import com.vietkiem.kimtinviinthoicabn.common.base.BaseActivity
import com.vietkiem.kimtinviinthoicabn.common.binding.viewBinding
import com.vietkiem.kimtinviinthoicabn.common.ui.UiEvent
import com.vietkiem.kimtinviinthoicabn.databinding.FragmentHomeBinding
import com.vietkiem.kimtinviinthoicabn.earn.utils.Asset
import com.vietkiem.kimtinviinthoicabn.earn.utils.ButtonEnum
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home), HomeController.Listener, BottomSheetController.Listener {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<DataViewModel>()

    private val bottomSheetBehavior by lazy {
        BottomSheetBehavior.from(binding.bottomSheet)
    }

    private val navigation by lazy {
        requireActivity() as BaseActivity.AppNavigator
    }

    private val controller by lazy {
        HomeController(this)
    }

    private val bottomSheetController by lazy {
        BottomSheetController(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.uiEvent.observe(viewLifecycleOwner){
            when(it){
                is UiEvent.Error -> {}
                is UiEvent.Loading -> bottomSheetController.setIsLoading(it.isloading)
                is HomeEvent.EarnSuccess -> bottomSheetController.buildData(it.data, ButtonEnum.EARN)
                is HomeEvent.SaveSuccess -> bottomSheetController.buildData(it.data, ButtonEnum.SAVE)
                is HomeEvent.CryptoSuccess -> bottomSheetController.buildData(it.data, ButtonEnum.CRYPTO)
                is HomeEvent.SellSuccess -> bottomSheetController.buildData(it.data, ButtonEnum.SELL)
            }
        }

        viewModel.getData(ButtonEnum.EARN)

        setupViews()
    }

    private fun setupViews() {

        binding.view2.setOnClickListener {
            if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            else bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        binding.epoxyRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.epoxyRecycler.setController(controller)
        controller.requestModelBuild()

        binding.bottomSheetEpoxy.layoutManager = LinearLayoutManager(requireContext())
        binding.bottomSheetEpoxy.setController(bottomSheetController)
    }

    override fun onButtonListener(id: String) {
        when(id){
            Asset.EARN -> requestData(ButtonEnum.EARN)
            Asset.SAVE-> requestData(ButtonEnum.SAVE)
            Asset.CRYPTO -> requestData(ButtonEnum.CRYPTO)
            Asset.SELL -> requestData(ButtonEnum.SELL)
            (R.drawable.ic_banner).toString() -> navigation.jumpToWebView(1)
            (R.drawable.ic_banner_2).toString() -> navigation.jumpToWebView(2)
        }
    }

    override fun onDataItemClick(data: Content) {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        navigation.onDetailsNavigate(data)
    }

    private fun requestData(buttonEnum: ButtonEnum){
        viewModel.getData(buttonEnum)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
    }

}