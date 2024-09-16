package com.example.movietrackerapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietrackerapp.databinding.MovieItemBinding
import com.example.movietrackerapp.model.remote.service.response.Results

class MovieAdapter(private val dataSet: ArrayList<Results>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(private val binding: MovieItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(movie: Results){
                Glide.with(binding.moviePoster)
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                    .into(binding.moviePoster)
                binding.movieTitle.text = movie.title
                binding.movieOverview.text = movie.overview
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie: Results = dataSet[position]
        holder.bind(movie)
    }
}