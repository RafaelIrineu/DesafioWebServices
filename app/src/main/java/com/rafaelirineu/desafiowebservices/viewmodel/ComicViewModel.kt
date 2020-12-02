package com.rafaelirineu.desafiowebservices.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.repository.ComicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher

class ComicViewModel(private val repository: ComicRepository) : ViewModel() {

    private var _comics: List<ComicModel> = listOf()
    private lateinit var uniqueComic: ComicModel

    fun obterComic() = liveData(Dispatchers.IO) {
        try {
            val response = repository.obterComic()
            _comics = response.data.results
            emit(_comics)
        } catch (e: Exception) {
            println("Ocorreu um erro : ${e.message} ")
        }
    }

    fun getUniqueComic(id: Int) = liveData(Dispatchers.IO) {

        try {
            val response = repository.getUniqueComic(id)
            uniqueComic = response.data.results[0]
            emit(uniqueComic)

        } catch (e: Exception) {
            println("Ocorreu um erro : ${e.message}")
        }
    }

    class ComicViewModelFactory(
        private val repository: ComicRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }
}