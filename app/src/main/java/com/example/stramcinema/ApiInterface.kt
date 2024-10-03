package com.example.stramcinema

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("3/movie/popular?api_key=5029377671105e0897cc53a9f75838d6&append_to_response=videos,images")
    fun getData(): Call<responseDataClass>


}