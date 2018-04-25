package com.example.mrizk.workpostureevaluationrula_reba.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {

    public static GuideFragment newInstance() {
        GuideFragment guideFragment = new GuideFragment();
        return guideFragment;
    }


    public GuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }

}
