package com.example.movietrackerapp

import com.example.movietrackerapp.model.remote.datasource.MovieServiceRemoteDataSourceImpl
import com.example.movietrackerapp.model.repository.MovieServiceRepositoryImpl

class AppContainer {
    private val movieServiceRemoteDataSource = MovieServiceRemoteDataSourceImpl()
    val movieServiceRepository = MovieServiceRepositoryImpl(movieServiceRemoteDataSource)
}