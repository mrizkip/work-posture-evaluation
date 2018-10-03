package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.mrizk.workpostureevaluationrula_reba.R;

public class DialogHealthCare extends DialogFragment {

    private Context context;
    private String[] images = {
            "file:///android_asset/healthy_1.png",
            "file:///android_asset/healthy_2.png",
            "file:///android_asset/healthy_3.png",
            "file:///android_asset/healthy_4.png"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_health_care, container, false);
        (rootView.findViewById(R.id.dialogHealth_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        ViewPager viewPager = rootView.findViewById(R.id.dialogHealth_viewPager);
        ViewPagerHealthCareAdapter adapter = new ViewPagerHealthCareAdapter(context, images);
        viewPager.setAdapter(adapter);
        return rootView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}