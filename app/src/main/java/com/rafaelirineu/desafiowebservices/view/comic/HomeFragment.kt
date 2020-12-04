package com.rafaelirineu.desafiowebservices.view.comic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.data.repository.ComicRepository
import com.rafaelirineu.desafiowebservices.viewmodel.ComicViewModel

class HomeFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel
    private lateinit var _listaAdapter: ComicAdapter
    private var _listaComic = mutableListOf<ComicModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val manager = GridLayoutManager(view.context, 3)
        val navControl = Navigation.findNavController(view)

        _listaComic = mutableListOf()
        _listaAdapter = ComicAdapter(_listaComic) {

            val bundle = bundleOf(ID_KEY to it.id)
            navControl.navigate(R.id.action_homeFragment_to_comicInfoFragment, bundle)
        }

        recyclerView.apply{
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this, ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.obterTodasComics().observe(viewLifecycleOwner,{
            it.let{_listaComic.addAll(it)}
            _listaAdapter.notifyDataSetChanged()
        })
    }

    companion object {
        const val ID_KEY = "ID"
    }
}