package com.example.movietrackerapp.model.repository

import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.utils.ResponseWrapper

interface MovieServiceRepository {
    suspend fun getRecommendations(): ResponseWrapper<MovieResponse>
}