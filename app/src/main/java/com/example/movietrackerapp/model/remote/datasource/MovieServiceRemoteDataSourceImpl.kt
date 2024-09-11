package com.example.movietrackerapp.model.remote.datasource

import android.content.Context
import com.example.movietrackerapp.R
import com.example.movietrackerapp.model.remote.service.MovieService
import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.utils.ResponseWrapper

class MovieServiceRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val context: Context
): MovieServiceRemoteDataSource {
    override suspend fun getMovieRecommendations(): ResponseWrapper<MovieResponse> {
        return try {
            val response = movieService.getRecommendations(context.getString(R.string.api_key))
            val responseBody = response.body()
            if(response.isSuccessful && responseBody != null){
                ResponseWrapper.Success(data = responseBody)
            }else{
                val message = "Error Code: ${response.code()}, Message: ${response.errorBody()}"
                ResponseWrapper.Error(message = message)
            }
        }catch (e: Exception){
            ResponseWrapper.Error(message = "$e")
        }
    }
}