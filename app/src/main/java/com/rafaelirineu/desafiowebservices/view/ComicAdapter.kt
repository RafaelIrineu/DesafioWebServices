package com.rafaelirineu.desafiowebservices.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel

class ComicAdapter(private val dataSet: MutableList<ComicModel>, private var listener :
    (ComicModel) -> Unit): RecyclerView.Adapter<ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = dataSet.size
}