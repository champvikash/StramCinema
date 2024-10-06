package com.example.streamcinema.model.models

data class MovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)
