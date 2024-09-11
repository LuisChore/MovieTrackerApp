package com.example.movietrackerapp.model.remote.service

import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/top_rated")
    suspend fun getRecommendations(@Query("api_key") apiKey:String):Response<MovieResponse>
}