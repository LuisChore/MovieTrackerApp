package com.example.movietrackerapp.model.remote.service.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("results")
    var results : ArrayList<Results> = arrayListOf(),
)
