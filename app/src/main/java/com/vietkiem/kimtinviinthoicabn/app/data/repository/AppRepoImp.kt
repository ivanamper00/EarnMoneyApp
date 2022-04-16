package com.vietkiem.kimtinviinthoicabn.app.data.repository

import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.app.domain.model.Request
import com.vietkiem.kimtinviinthoicabn.app.domain.repository.AppRepo
import retrofit2.Response
import javax.inject.Inject

class AppRepoImp @Inject constructor(
    private val appRepo: AppRepo
): AppRepoGateway {

    override suspend fun getData(param: Request): Response<DataResponse> = appRepo.getData(param)
}