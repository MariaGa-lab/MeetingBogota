package com.mintic.meetingbogota


import com.google.gson.annotations.SerializedName

data class LugarItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("ciudad")
    val ciudad: String,
    @SerializedName("lugar")
    val lugar: String,
    @SerializedName("temperatura")
    val temperatura: Int,
    @SerializedName("urlPicture")
    val urlPicture: String
)