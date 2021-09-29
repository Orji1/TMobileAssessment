package com.example.tmobileassessment.model


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("page")
    val page: Page
)