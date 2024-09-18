package com.example.movietrackerapp.model.repository

import com.example.movietrackerapp.model.remote.datasource.MovieServiceRemoteDataSource
import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.utils.ResponseWrapper

class MovieServiceRepositoryImpl(
    private val movieServiceRemoteDataSource: MovieServiceRemoteDataSource
):MovieServiceRepository {
    override suspend fun getRecommendations(): ResponseWrapper<MovieResponse> {
        return movieServiceRemoteDataSource.getMovieRecommendations()
    }
}