package com.rafaelirineu.desafiowebservices.model

data class ComicModel(
    val id: Int,
    val thumbnail: ImageModel,
    val images: Array<ImageModel>,
    val issueNumber: Double,
    val title: String,
    val description: String,
    val dates: Array<ComicDate>,
    val prices: Array<ComicPrice>,
    val pageCount: Int
)