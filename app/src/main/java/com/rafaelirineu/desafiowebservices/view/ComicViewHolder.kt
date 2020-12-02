package com.rafaelirineu.desafiowebservices.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.squareup.picasso.Picasso

class ComicViewHolder(private val _itemView: View) : RecyclerView.ViewHolder(_itemView) {

    private var _ivImageComic = _itemView.findViewById<ImageView>(R.id.comicImage)
    private var _tvIssueNumber = _itemView.findViewById<TextView>(R.id.txtIssueNumber)

    @SuppressLint("SetTextI18n")
    fun bind(comic: ComicModel) {

        _tvIssueNumber.text = "# ${comic.id}"

        val imagePath = comic.thumbnail?.getImagePath()

        Picasso.get()
            .load(imagePath)
            .into(_ivImageComic)
    }
}
