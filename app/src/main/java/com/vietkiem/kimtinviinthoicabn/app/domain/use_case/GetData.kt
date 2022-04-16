package com.vietkiem.kimtinviinthoicabn.app.domain.use_case

import com.vietkiem.kimtinviinthoicabn.app.data.repository.AppRepoGateway
import com.vietkiem.kimtinviinthoicabn.app.domain.model.Request
import javax.inject.Inject

class GetData @Inject constructor(
    private val appRepoImp: AppRepoGateway
) {

    suspend operator fun invoke(param: Request) = appRepoImp.getData(param)
}