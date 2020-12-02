package com.rafaelirineu.desafiowebservices.repository

import com.rafaelirineu.desafiowebservices.network.PUBLIC_KEY
import com.rafaelirineu.desafiowebservices.network.getHash
import com.rafaelirineu.desafiowebservices.network.getTimeStamp

class ComicRepository {

    private val client = ComicEndpoint.Endpoint

    suspend fun obterComic() = client.obterComic(
        "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        PUBLIC_KEY
    )

    suspend fun getUniqueComic(id: Int) = client.getUniqueComic(
        id, "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        PUBLIC_KEY
    )
}