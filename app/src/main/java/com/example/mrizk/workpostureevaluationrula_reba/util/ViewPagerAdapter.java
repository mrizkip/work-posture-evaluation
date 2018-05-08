package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.squareup.picasso.Picasso;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] images;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.view_pager_guide_item, container, false);

        ImageView image;
        image = itemView.findViewById(R.id.guideItem_imageView);
        DisplayMetrics dis = context.getResources().getDisplayMetrics();
        int height = dis.heightPixels;
        int width = dis.widthPixels;
        image.setMinimumHeight(height);
        image.setMinimumWidth(width);

        try {
            Picasso.get().load(images[position]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View)object);
    }
}
