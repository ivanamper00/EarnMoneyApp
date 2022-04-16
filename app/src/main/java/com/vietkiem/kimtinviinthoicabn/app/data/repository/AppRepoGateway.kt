package com.vietkiem.kimtinviinthoicabn.app.data.repository

import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.app.domain.model.Request
import retrofit2.Response

interface AppRepoGateway {
    suspend fun getData(param: Request): Response<DataResponse>
}