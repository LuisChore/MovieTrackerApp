package com.example.movietrackerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.movietrackerapp.App
import com.example.movietrackerapp.model.repository.MovieServiceRepository

class MovieServiceViewModel(
    private val movieServiceRepository: MovieServiceRepository
):ViewModel() {
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
}