package com.wahyubagus.movieapp.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.wahyubagus.movieapp.R;
import com.wahyubagus.movieapp.adapters.MovieAdapter;
import com.wahyubagus.movieapp.adapters.SliderPagerAdapter;
import com.wahyubagus.movieapp.dto.Movie;
import com.wahyubagus.movieapp.dto.Slide;
import com.wahyubagus.movieapp.listener.MovieItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> slideList;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        movieRecyclerView = findViewById(R.id.rvMovie);

        // prepare list of slides
        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.thebatman, "The Batman - (2022)"));
        slideList.add(new Slide(R.drawable.spiderverse, "Spider-Man: into the spider verse - (2017)"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, slideList);
        sliderPager.setAdapter(adapter);

        // setup time
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderPager, true);

        // Recycler View setup
        // ini data

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Dunkrik", R.drawable.dunkrik, R.drawable.dunkrik_cover));
        movieList.add(new Movie("Her", R.drawable.her));
        movieList.add(new Movie("Logan", R.drawable.logan));
        movieList.add(new Movie("Bird Box", R.drawable.bird_box));
        movieList.add(new Movie("Up", R.drawable.up));
        movieList.add(new Movie("Tenet", R.drawable.tenet));

        MovieAdapter movieAdapter = new MovieAdapter(this, movieList, this);
        movieRecyclerView.setAdapter(movieAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    /*
    Here we will share information to detail activity,
    also we will create the transition animation between the two activity
    * */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImage) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());

        // lets craete the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                HomeActivity.this, movieImage, "sharedName"
        );
        startActivity(intent, options.toBundle());

        Toast.makeText(this, "item clicked: " + movie.getTitle(), Toast.LENGTH_LONG).show();
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < slideList.size() - 1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}