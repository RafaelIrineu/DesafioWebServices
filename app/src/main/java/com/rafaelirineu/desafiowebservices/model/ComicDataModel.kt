package com.rafaelirineu.desafiowebservices.model

import androidx.annotation.Keep

@Keep
data class ComicDataModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHtml: String,
    val data: ComicDataContainerModel,
    val etag: String
)