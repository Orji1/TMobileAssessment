package com.example.tmobileassessment.model


import com.google.gson.annotations.SerializedName

data class AttributesX(
    @SerializedName("font")
    val font: FontX,
    @SerializedName("text_color")
    val textColor: String
)