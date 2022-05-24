package com.amvlabs.kotlinsamples.retrofitsample

import com.google.gson.annotations.SerializedName

data class Datum(
    val id: Long,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)
