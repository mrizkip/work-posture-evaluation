package com.example.mrizk.workpostureevaluationrula_reba.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.util.ViewPagerGuideAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {

    private Context context;
    ViewPager viewPager;
    ViewPagerGuideAdapter adapter;

    private String[] images = {
            "file:///android_asset/home.png",
            "file:///android_asset/guide_angle.png"
    };

    public static GuideFragment newInstance() {
        GuideFragment guideFragment = new GuideFragment();
        return guideFragment;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    public GuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        viewPager = view.findViewById(R.id.guide_viewPager);
        adapter = new ViewPagerGuideAdapter(context, images);
        viewPager.setAdapter(adapter);

        return view;
    }



}
