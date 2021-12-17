package com.wahyubagus.movieapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.wahyubagus.movieapp.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView movieThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // get the data

        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        movieThumbnail = findViewById(R.id.detailMovieImage);
        movieThumbnail.setImageResource(imageResourceId);

    }
}