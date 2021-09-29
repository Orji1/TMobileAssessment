package com.example.tmobileassessment.model.network

import com.example.tmobileassessment.BuildConfig
import com.example.tmobileassessment.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ResponseApi {
    @GET(BuildConfig.END_POINT)
    suspend fun getResponse(): Response<ResponseData>
}