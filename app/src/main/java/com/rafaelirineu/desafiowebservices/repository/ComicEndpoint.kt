package com.rafaelirineu.desafiowebservices.repository

import com.rafaelirineu.desafiowebservices.model.ComicDataWrapper
import com.rafaelirineu.desafiowebservices.network.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicEndpoint {

    @GET("/v1/public/comics")
    suspend fun obterTodasComics(
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataWrapper

    @GET("/v1/public/comics/{id}")
    suspend fun obterUmaComic(
        @Path("id") id:Int,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataWrapper

    companion object {
        val Endpoint: ComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
        }
    }
}