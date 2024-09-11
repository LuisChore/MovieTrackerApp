package com.example.movietrackerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.movietrackerapp.App
import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.model.remote.service.response.Results
import androidx.lifecycle.viewModelScope
import com.example.movietrackerapp.model.repository.MovieServiceRepository
import com.example.movietrackerapp.utils.ResponseWrapper
import kotlinx.coroutines.launch

class MovieServiceViewModel(
    private val movieServiceRepository: MovieServiceRepository
):ViewModel() {
    private val _movieRecommendations: MutableLiveData<ResponseWrapper<MovieResponse>> =
        MutableLiveData(ResponseWrapper.Loading())
    val movieRecommendations: LiveData<ResponseWrapper<MovieResponse>> = _movieRecommendations

    companion object{
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return MovieServiceViewModel(
                    (application as App).appContainer.movieServiceRepository,
                ) as T
            }
        }
    }

    fun onGetRecommendations(){
        viewModelScope.launch {
            _movieRecommendations.postValue(movieServiceRepository.getRecommendations())
        }
    }
}