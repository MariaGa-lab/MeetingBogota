package com.mintic.meetingbogota.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mintic.meetingbogota.databinding.ActivityDetalleBinding
import com.mintic.meetingbogota.model.LugarItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {
   
    private lateinit var detalleBinding: ActivityDetalleBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)
    
        val lugar: LugarItem = intent.extras?.getSerializable("lugar") as LugarItem
    
        with(detalleBinding){
            sitioTextView.text = lugar.lugar
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
            descripcionTextView.text = lugar.descripcion
        }

    }
}