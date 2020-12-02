package com.rafaelirineu.desafiowebservices.viewmodel.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.squareup.picasso.Picasso

class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var _ivImageComic = itemView.findViewById<ImageView>(R.id.img_layoutItemComic)
    private var _tvIssueNumber = itemView.findViewById<TextView>(R.id.txt_layoutItemComic)

    @SuppressLint("SetTextI18n")
    fun bind(comic: ComicModel) {

        _tvIssueNumber.text = "# " + comic.id.toString()

        Picasso.get()
            .load("${comic.thumbnail.path}/portrait_uncanny.${comic.thumbnail.extension}")
            .into(_ivImageComic)
    }
}
