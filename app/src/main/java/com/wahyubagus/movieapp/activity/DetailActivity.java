package com.wahyubagus.movieapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wahyubagus.movieapp.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView movieThumbnail, movieCoverImg;
    private TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iniViews();


    }

    void iniViews(){
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageCoverId = getIntent().getExtras().getInt("imgCover");
        movieThumbnail = findViewById(R.id.detailMovieImage);
        movieCoverImg = findViewById(R.id.detailMovieCover);
        Glide.with(this).load(imageCoverId).into(movieCoverImg);
        movieThumbnail.setImageResource(imageResourceId);
        title = findViewById(R.id.detailMovieTitle);
        title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        description = findViewById(R.id.detail_movie_desc);
    }
}