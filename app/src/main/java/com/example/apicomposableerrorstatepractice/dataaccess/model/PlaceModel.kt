package com.example.apicomposableerrorstatepractice.dataaccess.model


import com.google.gson.annotations.SerializedName

data class PlaceModel(
    @SerializedName("latitude")
    val latitude: String? = "",
    @SerializedName("longitude")
    val longitude: String? = "",
    @SerializedName("place name")
    val placeName: String? = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("state abbreviation")
    val stateAbbreviation: String? = ""
)