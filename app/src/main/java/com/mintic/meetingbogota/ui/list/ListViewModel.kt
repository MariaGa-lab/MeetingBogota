package com.mintic.meetingbogota.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.mintic.meetingbogota.data.LugaresRepository
import com.mintic.meetingbogota.model.Lugar
import com.mintic.meetingbogota.model.LugarItem
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var lugaresLoad : MutableLiveData<ArrayList<LugarItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugarItem>> = lugaresLoad

    private val repository = LugaresRepository()

    @DelicateCoroutinesApi
    fun getLugaresFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            lugaresLoad.postValue(repository.getLugares())
        }
    }

    fun loadMockLugaresFromJson(lugaresString: InputStream?) {
        val lugarString = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value = gson.fromJson(lugarString, Lugar::class.java)
    }
}