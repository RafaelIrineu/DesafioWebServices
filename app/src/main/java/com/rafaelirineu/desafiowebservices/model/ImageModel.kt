package com.rafaelirineu.desafiowebservices.model

data class ImageModel(val path: String, val extension: String) {
    fun getImagePath(imageResolution: String? = "detail"): String {
        return "$path/$imageResolution.$extension".replace("http://", "https://")
    }
}