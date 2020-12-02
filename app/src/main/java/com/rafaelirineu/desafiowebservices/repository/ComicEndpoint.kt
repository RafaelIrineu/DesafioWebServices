package com.rafaelirineu.desafiowebservices.repository

import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.network.NetworkUtils
import retrofit2.http.GET

interface ComicEndpoint {
    @GET("/v1/public/comics/")
    suspend fun obterComic(): List<ComicModel>

    companion object{
        val Endpoint: ComicEndpoint by lazy{
            NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
        }
    }
}