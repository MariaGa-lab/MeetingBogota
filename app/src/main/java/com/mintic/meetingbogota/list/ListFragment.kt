package com.mintic.meetingbogota.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mintic.meetingbogota.R
import com.mintic.meetingbogota.databinding.FragmentListBinding
import com.mintic.meetingbogota.main.MainActivity
import com.mintic.meetingbogota.model.Lugar
import com.mintic.meetingbogota.model.LugarItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var listLugar: ArrayList<LugarItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listLugar = loadMockLugarFromJson()
        lugaresAdapter = LugaresAdapter(listLugar, onItemClicked = { onLugarClicked(it) } )

        listBinding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugarClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }

    private fun loadMockLugarFromJson(): ArrayList<LugarItem> {
        val lugarString: String = context?.assets?.open("lugaresturisticos.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val lugarList = gson.fromJson(lugarString, Lugar::class.java)
        return lugarList
    }
}