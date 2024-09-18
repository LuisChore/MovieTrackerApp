package com.example.movietrackerapp

import android.content.Context
import com.example.movietrackerapp.model.remote.datasource.MovieServiceRemoteDataSourceImpl
import com.example.movietrackerapp.model.remote.service.MovieService
import com.example.movietrackerapp.model.repository.MovieServiceRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(
    context: Context
) {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val retrofitService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
    private val movieServiceRemoteDataSource = MovieServiceRemoteDataSourceImpl(retrofitService,context)
    val movieServiceRepository = MovieServiceRepositoryImpl(movieServiceRemoteDataSource)
}