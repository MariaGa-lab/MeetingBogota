package com.mintic.meetingbogota.data

class LugaresRepository {

    suspend  fun getLugares() = Apifactory.retrofit.getSitiosturisticos()

}