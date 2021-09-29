package com.example.tmobileassessment.model.repository

import com.example.tmobileassessment.model.ResponseData
import com.example.tmobileassessment.model.network.Network

class Repository : IRepository {
    sealed class DataState {
        class Data(val data: ResponseData?) : DataState()
        class Error(val errMsg: String) : DataState()
        object Loading : DataState()
    }

    override suspend fun getResponse(): DataState {
        val response =
            Network.getInstance().getApi().getResponse()
        return if (response.isSuccessful)
            DataState.Data(response.body())
        else
            DataState.Error(response.message())
    }
}