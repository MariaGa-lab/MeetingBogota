package com.mintic.meetingbogota.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mintic.meetingbogota.model.LugarItem
import com.mintic.meetingbogota.R
import com.squareup.picasso.Picasso

class LugaresAdapter (
    private val lugaresList : ArrayList<LugarItem>,
    private val onItemClicked: (LugarItem) -> Unit
    ) : RecyclerView.Adapter<LugaresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_place_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.itemView.setOnClickListener { onItemClicked(lugaresList[position]) }
        holder.bind(lugar)
    }

    override fun getItemCount(): Int = lugaresList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var temperaturaTextView: TextView =
            itemView.findViewById(R.id.temperatura_text_view)
        private var calificacionTextView: TextView =
            itemView.findViewById(R.id.calificacion_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(lugar: LugarItem) {
            nameTextView.text = lugar.lugar
            temperaturaTextView.text = lugar.temperatura.toString()
            calificacionTextView.text = lugar.calificacion
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)

        }
    }
}