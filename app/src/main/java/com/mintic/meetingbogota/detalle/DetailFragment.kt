package com.mintic.meetingbogota.detalle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mintic.meetingbogota.databinding.FragmentDetailBinding
import com.mintic.meetingbogota.detail.DetailViewModel
import com.mintic.meetingbogota.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

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
        val lugar = args.lugar

        with(detailBinding){
            sitioTextView.text = lugar.lugar
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
            descripcionTextView.text = lugar.descripcion

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }
        }
    }
}