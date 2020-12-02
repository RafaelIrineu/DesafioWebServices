package com.rafaelirineu.desafiowebservices.model

data class ComicModel(
    val id: Int,
    val thumbnail: ImageModel,
    val images: List<ImageModel>,
    val issueNumber: Double,
    val title: String,
    val description: String,
    val dates: List<ComicDate>,
    val prices: List<ComicPrice>,
    val pageCount: Int
)