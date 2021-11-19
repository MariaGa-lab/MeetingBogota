package com.mintic.meetingbogota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListPlacesActivity : AppCompatActivity() {

    private lateinit var listPlaces : ArrayList<LugarItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_places)

        placesRecyclerView = findViewById(R.id.places_recycler_view)

        listPlaces = LoadMockPlacesFromJson()
        lugaresAdapter = LugaresAdapter(listPlaces)

        placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun LoadMockPlacesFromJson() : ArrayList<LugarItem> {
        var lugaresString: String = applicationContext.assets.open("lugaresturisticos.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString, Lugar::class.java)
        return data
    }
}