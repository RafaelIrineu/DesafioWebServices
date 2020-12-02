package com.rafaelirineu.desafiowebservices.viewmodel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel

class ComicAdapter(private val dataSet: List<ComicModel>,private var listener :
    (ComicModel) -> Unit): RecyclerView.Adapter<ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener {
            listener(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size

}