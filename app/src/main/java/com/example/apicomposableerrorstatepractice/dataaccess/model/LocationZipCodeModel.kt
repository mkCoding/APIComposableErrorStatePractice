package com.example.apicomposableerrorstatepractice.dataaccess.model


import com.google.gson.annotations.SerializedName

data class LocationZipCodeModel(
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("country abbreviation")
    val countryAbbreviation: String? = "",
    @SerializedName("places")
    val places: List<PlaceModel?>? = listOf(),
    @SerializedName("post code")
    val postCode: String? = ""
)