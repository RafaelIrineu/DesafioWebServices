package com.rafaelirineu.desafiowebservices.repository

import com.rafaelirineu.desafiowebservices.model.ComicDataModel
import com.rafaelirineu.desafiowebservices.model.ComicModel
import com.rafaelirineu.desafiowebservices.network.NetworkUtils
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicEndpoint {

    @GET("/v1/public/comics/")
    suspend fun obterComic(
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataModel

    @GET("/v1/public/comics/{id}")
    suspend fun getUniqueComic(
        @Path("id") id: Int,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataModel

    companion object {
        val Endpoint: ComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
        }
    }
}