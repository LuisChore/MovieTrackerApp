package com.example.movietrackerapp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.movietrackerapp.R
import com.example.movietrackerapp.model.remote.service.response.MovieResponse
import com.example.movietrackerapp.utils.ResponseWrapper
import com.example.movietrackerapp.viewmodel.MovieServiceViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MovieServiceViewModel by viewModels { MovieServiceViewModel.Factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setStateObservers()
        viewModel.onGetRecommendations()

    }

    private fun setStateObservers() {
        viewModel.movieRecommendations.observe(this){ state->
            when(state){
                is ResponseWrapper.Error -> setErrorUI(state.message)
                is ResponseWrapper.Loading -> setLoadingUI()
                is ResponseWrapper.Success -> setSuccessStateUI(state.data)

            }

        }
    }

    private fun setLoadingUI() {
        Toast.makeText(this,"Loading...",Toast.LENGTH_LONG).show()
    }

    private fun setErrorUI(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    private fun setSuccessStateUI(data: MovieResponse) {
        val movies = data.results
        movies.forEach { it->
            Log.d("TAG","${it.title}")
        }
    }

}