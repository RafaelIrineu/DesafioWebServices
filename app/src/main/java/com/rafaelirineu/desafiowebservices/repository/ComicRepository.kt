package com.rafaelirineu.desafiowebservices.repository

class ComicRepository {

    private val client = ComicEndpoint.Endpoint

    suspend fun obterComic() = client.obterComic()

}