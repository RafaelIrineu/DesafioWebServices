package com.rafaelirineu.desafiowebservices.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.viewmodel.ComicViewModel

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

        val navController = Navigation.findNavController(view)

        view.findViewById<ImageView>(R.id.imgBack_fragmentComicInfo).setOnClickListener {
            navController.navigate(R.id.action_comicInfoFragment_to_homeFragment)
        }
    }
}