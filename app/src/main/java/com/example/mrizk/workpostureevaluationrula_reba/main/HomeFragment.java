package com.example.mrizk.workpostureevaluationrula_reba.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.home_buttonStart)
    Button btnStart;
    @BindView(R.id.home_imageHome)
    ImageView imageHome;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        Picasso.get().load("file:///android_asset/home.png").into(imageHome);

        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), IntroductionActivity.class);
            startActivity(intent);
        });

        return view;
    }

}
