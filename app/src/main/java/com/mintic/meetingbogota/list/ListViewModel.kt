package com.cubidevs.dccomics.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.mintic.meetingbogota.model.Lugar
import com.mintic.meetingbogota.model.LugarItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var lugaresLoad : MutableLiveData<ArrayList<LugarItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugarItem>> = lugaresLoad

    fun loadMockLugaresFromJson(lugaresString: InputStream?) {
        val lugarString = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value = gson.fromJson(lugarString, Lugar::class.java)
    }
}