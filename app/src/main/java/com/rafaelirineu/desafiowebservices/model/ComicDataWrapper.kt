package com.rafaelirineu.desafiowebservices.model

data class ComicDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHtml: String,
    val data: ComicDataContainer,
    val etag: String
)
