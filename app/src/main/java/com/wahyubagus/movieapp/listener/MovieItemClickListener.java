package com.wahyubagus.movieapp.listener;

import android.widget.ImageView;

import com.wahyubagus.movieapp.dto.Movie;

public interface MovieItemClickListener {

    // we will need the image view to make the shared animation between
    // the two activity
    void onMovieClick(Movie movie, ImageView movieImage);

}
