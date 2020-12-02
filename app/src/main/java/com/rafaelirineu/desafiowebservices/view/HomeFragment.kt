package com.rafaelirineu.desafiowebservices.view

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
import com.rafaelirineu.desafiowebservices.model.ComicDataModel
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.repository.ComicRepository
import com.rafaelirineu.desafiowebservices.viewmodel.ComicViewModel

class HomeFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel
    private lateinit var _view: View
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

        _listaAdapter = ComicAdapter(_listaComic) {

            val bundle = bundleOf("id" to it.id.toInt())
            val navControl = Navigation.findNavController(view)
            navControl.navigate(R.id.action_homeFragment_to_comicInfoFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            adapter = _listaAdapter
            layoutManager = manager
        }

        _viewModel = ViewModelProvider(
            this, ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.obterComic().observe(viewLifecycleOwner, {
            mostrarResultados(it)
        })
    }

    private fun mostrarResultados(lista: List<ComicModel>) {
        if (_listaComic.isEmpty()) {
            lista.let { _listaComic.addAll(lista) }
            _listaAdapter.notifyDataSetChanged()
        }
    }
}


