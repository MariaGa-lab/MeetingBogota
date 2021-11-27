package com.mintic.meetingbogota.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("ciudad")
    val ciudad: String,
    @SerializedName("lugar")
    val lugar: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("temperatura")
    val temperatura: Int,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable