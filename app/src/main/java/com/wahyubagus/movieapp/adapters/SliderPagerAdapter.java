package com.wahyubagus.movieapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wahyubagus.movieapp.R;
import com.wahyubagus.movieapp.Slide;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Slide> slideList;

    public SliderPagerAdapter(Context context, List<Slide> slideList) {
        this.context = context;
        this.slideList = slideList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View slideLayout = inflater.inflate(R.layout.slide_item, null);

        ImageView slideImage = slideLayout.findViewById(R.id.slide_img);
        TextView slideText = slideLayout.findViewById(R.id.slide_title);
        slideImage.setImageResource(slideList.get(position).getImage());
        slideText.setText(slideList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return slideList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
