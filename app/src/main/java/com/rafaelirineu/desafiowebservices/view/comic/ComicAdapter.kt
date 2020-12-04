package com.rafaelirineu.desafiowebservices.view.comic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel

class ComicAdapter(
    private val _dataSet: MutableList<ComicModel>, private var _listener:
        (ComicModel) -> Unit) : RecyclerView.Adapter<ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_comic_list_item, parent, false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = _dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { _listener(item) }
    }

    override fun getItemCount() = _dataSet.size
}