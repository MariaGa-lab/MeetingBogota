package com.mintic.meetingbogota.data

import com.mintic.meetingbogota.model.Lugar
import retrofit2.http.GET

interface ApiService {
    @GET("MariaGa-lab/MeetingBogota/sitiosturisticos")
    suspend fun getSitiosturisticos(): Lugar

}