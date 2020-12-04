package com.rafaelirineu.desafiowebservices.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class ComicViewModel(private val _repository: ComicRepository) : ViewModel() {

    private var _listaComics: List<ComicModel> = listOf()
    private lateinit var _comic: ComicModel

    fun obterTodasComics() = liveData(Dispatchers.IO) {
        try {
            val response = _repository.obterTodasComics().data.results
            _listaComics = response
            emit(response)
        } catch (e: Exception) {
            println("Ocorreu um erro : ${e.message} ")
        }
    }

    fun obterUmaComic(id: Int) = liveData(Dispatchers.IO) {
        val response = _repository.obterUmaComic(id).data.results[0]
        _comic = response
        emit(response)
    }

    class ComicViewModelFactory(
        private val repository: ComicRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }
}