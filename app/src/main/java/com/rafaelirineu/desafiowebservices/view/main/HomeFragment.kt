package com.rafaelirineu.desafiowebservices.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.desafiowebservices.R
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.repository.ComicRepository
import com.rafaelirineu.desafiowebservices.viewmodel.ComicViewModel
import com.rafaelirineu.desafiowebservices.viewmodel.adapter.ComicAdapter

class HomeFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel
    private lateinit var _view: View
    private lateinit var _listaAdapter: ComicAdapter
    private lateinit var recyclerView: RecyclerView
    private var _listaComic = mutableListOf<ComicModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        recyclerView = _view.findViewById(R.id.recyclerView)

        val manager = GridLayoutManager(view.context, 3)

        _listaAdapter = ComicAdapter(_listaComic) {

            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = manager
                adapter = _listaAdapter
            }

            _viewModel = ViewModelProvider(this,ComicViewModel.
            ComicViewModelFactory(ComicRepository())).get(ComicViewModel::class.java)

            _viewModel.obterComic().observe(viewLifecycleOwner) {
                mostrarResultados(it)
            }
        }
    }

        private fun mostrarResultados(lista: List<ComicModel>){
            lista?.let{_listaComic.addAll(it)}
            _listaAdapter.notifyDataSetChanged()
        }
}