package com.example.stramcinema

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //https://api.themoviedb.org/3/movie/popular?api_key=5029377671105e0897cc53a9f75838d6&append_to_response=videos,images

    //    //https://api.themoviedb.org
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}