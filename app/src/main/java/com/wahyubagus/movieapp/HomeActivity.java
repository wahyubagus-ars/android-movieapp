package com.wahyubagus.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.wahyubagus.movieapp.adapters.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> slideList;
    private ViewPager sliderPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderPager = findViewById(R.id.slider_pager);

        // prepare list of slides
        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.thebatman, "The Batman"));
        slideList.add(new Slide(R.drawable.spiderverse, "Spiderverse"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, slideList);
        sliderPager.setAdapter(adapter);
    }
}