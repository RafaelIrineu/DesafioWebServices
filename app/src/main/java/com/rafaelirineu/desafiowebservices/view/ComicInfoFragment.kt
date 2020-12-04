package com.rafaelirineu.desafiowebservices.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.view.HomeFragment.Companion.ID_KEY
import com.rafaelirineu.desafiowebservices.repository.ComicRepository
import com.rafaelirineu.desafiowebservices.viewmodel.ComicViewModel
import com.squareup.picasso.Picasso

class ComicInfoFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comic_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val obterId = arguments?.getInt(ID_KEY)
        var comic: ComicModel

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        if (obterId != null) {
            _viewModel.obterUmaComic(obterId).observe(viewLifecycleOwner) {
                val newThumb = "${it.thumbnail.path}${it.thumbnail.extension}"
                val newCover = "${it.thumbnail.path}/portrait_uncanny.${it.thumbnail.extension}"
                val newPage = it.pageCount

                val newPrice = it.prices[0].price

                val newTitle = it.title
                val newSummary = it.description
                val newPublished = it.dates[0].date.split("T")

                val thumbnail = view.findViewById<ImageView>(R.id.imgBackground_fragmentComicInfo)
                val cover = view.findViewById<ImageView>(R.id.imgThumb_fragmentItemComic)

                val title = view.findViewById<TextView>(R.id.txtTitle_fragmentComicInfo)
                val summary = view.findViewById<TextView>(R.id.txtDescription)

                val published = view.findViewById<TextView>(R.id.txtPublished_fragmentComicInfo)
                val pages = view.findViewById<TextView>(R.id.txtPages_fragmentComicInfo)
                val price = view.findViewById<TextView>(R.id.txtPrice_fragmentComicInfo)

                title.text = newTitle.toString()
                summary.text = newSummary.toString()
                published.text = newPublished.toString()
                pages.text = newPage.toString()
                price.text = newPrice.toString()

                Picasso.get()
                    .load("${it.thumbnail.path}/portrait_uncanny.${it.thumbnail.extension}")
                    .into(cover)
                Picasso.get().load("${it.thumbnail.path}${it.thumbnail.extension}").into(thumbnail)
            }
        }

        val navController = Navigation.findNavController(view)

        view.findViewById<ImageView>(R.id.imgBack_fragmentComicInfo).setOnClickListener {
            navController.navigate(R.id.action_comicInfoFragment_to_homeFragment)
        }
    }
}