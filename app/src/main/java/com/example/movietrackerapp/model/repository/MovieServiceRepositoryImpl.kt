package com.example.movietrackerapp.model.repository

import com.example.movietrackerapp.model.remote.datasource.MovieServiceRemoteDataSource

class MovieServiceRepositoryImpl(
    private val movieServiceRemoteDataSource: MovieServiceRemoteDataSource

):MovieServiceRepository {
}