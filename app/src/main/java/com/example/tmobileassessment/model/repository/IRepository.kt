package com.example.tmobileassessment.model.repository

interface IRepository {
    suspend fun getResponse(): Repository.DataState
}