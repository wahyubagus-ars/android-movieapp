package com.wahyubagus.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.wahyubagus.movieapp.adapters.MovieAdapter;
import com.wahyubagus.movieapp.adapters.SliderPagerAdapter;
import com.wahyubagus.movieapp.dto.Movie;
import com.wahyubagus.movieapp.dto.Slide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

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
        movieList.add(new Movie("Dunkrik", R.drawable.dunkrik));
        movieList.add(new Movie("Her", R.drawable.her));
        movieList.add(new Movie("Logan", R.drawable.logan));
        movieList.add(new Movie("Bird Box", R.drawable.bird_box));
        movieList.add(new Movie("Up", R.drawable.up));
        movieList.add(new Movie("Tenet", R.drawable.tenet));

        MovieAdapter movieAdapter = new MovieAdapter(this, movieList);
        movieRecyclerView.setAdapter(movieAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

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