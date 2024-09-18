package com.example.movietrackerapp.model.remote.datasource

import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.utils.ResponseWrapper

interface MovieServiceRemoteDataSource {
    suspend fun getMovieRecommendations(): ResponseWrapper<MovieResponse>
}