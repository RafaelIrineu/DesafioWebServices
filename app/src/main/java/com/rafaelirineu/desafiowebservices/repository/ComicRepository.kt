package com.rafaelirineu.desafiowebservices.repository

import com.rafaelirineu.desafiowebservices.network.PUBLIC_KEY
import com.rafaelirineu.desafiowebservices.network.getHash
import com.rafaelirineu.desafiowebservices.network.getTimeStamp

class ComicRepository {
    private val _client = ComicEndpoint.Endpoint

    suspend fun obterTodasComics() = _client.obterTodasComics(
        "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        PUBLIC_KEY
    )

    suspend fun obterUmaComic(id: Int) = _client.obterUmaComic(
        id,
        "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        PUBLIC_KEY
    )
}