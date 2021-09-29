package com.example.tmobileassessment.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("size")
    val size: Size,
    @SerializedName("url")
    val url: String
)