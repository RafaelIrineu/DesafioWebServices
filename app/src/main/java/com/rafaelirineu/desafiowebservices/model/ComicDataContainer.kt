package com.rafaelirineu.desafiowebservices.model

import androidx.annotation.Keep

@Keep
data class ComicDataContainer(
    val results: List<ComicModel>,
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int
)