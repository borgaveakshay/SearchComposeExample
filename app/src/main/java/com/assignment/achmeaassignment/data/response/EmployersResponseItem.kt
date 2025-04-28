package com.assignment.achmeaassignment.data.response


import com.google.gson.annotations.SerializedName

data class EmployersResponseItem(
    @SerializedName("DiscountPercentage")
    val discountPercentage: Int,
    @SerializedName("EmployerID")
    val employerID: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Place")
    val place: String
)