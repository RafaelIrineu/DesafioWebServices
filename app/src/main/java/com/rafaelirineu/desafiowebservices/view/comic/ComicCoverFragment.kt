package com.rafaelirineu.desafiowebservices.view.comic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.rafaelirineu.desafiowebservices.R
import com.squareup.picasso.Picasso

class ComicCoverFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.fragment_comic_cover, container, false)

        val image = _view.findViewById<ImageView>(R.id.imageViewFull)
        val coverThumbnail = arguments?.getString(ComicInfoFragment.COMIC_IMAGE)
        Picasso.get().load(coverThumbnail).into(image)
        onCloseDialog(_view)

        return _view
    }

    private fun onCloseDialog(view: View) {
        view.findViewById<ImageView>(R.id.imgClose_fragmentComicCover).setOnClickListener {
            findNavController().navigateUp()
        }
    }
}