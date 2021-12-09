package com.mintic.meetingbogota.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mintic.meetingbogota.databinding.FragmentListBinding
import com.mintic.meetingbogota.ui.main.MainActivity
import com.mintic.meetingbogota.model.LugarItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugaresAdapter: LugaresAdapter
    private var listLugares: ArrayList<LugarItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        //listViewModel.loadMockLugaresFromJson(context?.assets?.open("lugaresturisticos.json"))

        listViewModel.getLugaresFromServer()

        listViewModel.onLugaresLoaded.observe(
            viewLifecycleOwner, { result ->
                onLugaresLoadedSubscribe(result)
            }
        )
        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = { onLugarClicked(it) })

        listBinding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugaresLoadedSubscribe(result: ArrayList<LugarItem>?) {
        result?.let { listLugares ->
            lugaresAdapter.appendItems(listLugares)
        }
    }

    private fun onLugarClicked(lugar: LugarItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }
}