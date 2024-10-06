package com.example.streamcinema.model.repo

import com.example.streamcinema.model.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {


    @GET("/")
    suspend fun getAllMovies(
        @Query("s")s:String,
        @Query("page")page:Int,
        @Query("apikey")apikey:String
    ):Response<MovieResponse>

}