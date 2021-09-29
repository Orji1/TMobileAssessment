package com.example.tmobileassessment.model


import com.google.gson.annotations.SerializedName

data class Size(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)