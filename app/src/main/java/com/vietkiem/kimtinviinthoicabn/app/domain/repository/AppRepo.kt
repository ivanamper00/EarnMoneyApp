package com.vietkiem.kimtinviinthoicabn.app.domain.repository

import com.vietkiem.kimtinviinthoicabn.app.domain.dto.DataResponse
import com.vietkiem.kimtinviinthoicabn.app.domain.model.Request
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppRepo {

    @POST("api/data")
    suspend fun getData(@Body param: Request): Response<DataResponse>
}