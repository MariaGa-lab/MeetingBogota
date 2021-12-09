package com.mintic.meetingbogota.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
//import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mintic.meetingbogota.R
import com.mintic.meetingbogota.databinding.FragmentDetailBinding
import com.mintic.meetingbogota.model.LugarItem
import com.mintic.meetingbogota.ui.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var lugar: LugarItem

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lugar = args.lugar
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(detailBinding){
            nameTextView.text = lugar.lugar
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
            descripcionTextView.text = lugar.descripcion
            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(lugar = lugar))
            }
        }
    }

    private  val callback = OnMapReadyCallback { googleMap ->

        val bogota = LatLng(lugar.latitud, lugar.longitud)
        googleMap.addMarker(
            MarkerOptions()
                .position(bogota)
                .title("Bogotá")
                .snippet("Bogotá"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota, 17F)
        )
    }

}