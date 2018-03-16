package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.util.CameraGallerySelectorDialog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RebaWristActivity extends AppCompatActivity {

    @BindView(R.id.reba_wrist_imageView)
    ImageView imageView;
    @BindView(R.id.reba_wrist_wrist_check1)
    CheckBox wrist1;
    @BindView(R.id.reba_wrist_load_radioGroup)
    RadioGroup wristLoadGroup;
    @BindView(R.id.reba_wrist_load_check1)
    CheckBox wristLoad1;
    @BindView(R.id.reba_wrist_coupling_radioGroup)
    RadioGroup couplingGroup;
    @BindView(R.id.reba_wrist_activity_check1)
    CheckBox activity1;
    @BindView(R.id.reba_wrist_activity_check2)
    CheckBox activity2;
    @BindView(R.id.reba_wrist_activity_check3)
    CheckBox activity3;

    @BindView(R.id.reba_wrist_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;

    private int wristValue = 0;
    private int wristPosition;
    private int loadValue = 0;
    private int loadRadio;
    private int couplingValue = 0;
    private int couplingRadio;
    private int activityValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_wrist);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
                actionBar.setTitle("REBA WRIST");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);

        // Check Wrist CheckBox
        wristValue = wristValue + wristPosition;
        wrist1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    wristValue = wristValue + 1;
                } else {
                    wristValue = wristValue - 1;
                }
            }
        });

        // Check Load RadioGroup and CheckBox
        wristLoadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.reba_wrist_load_radio1:
                        loadRadio = 0;
                        break;
                    case R.id.reba_wrist_load_radio2:
                        loadRadio = 1;
                        break;
                    case R.id.reba_wrist_load_radio3:
                        loadRadio = 2;
                        break;
                }
            }
        });
        loadValue = loadValue + loadRadio;

        wristLoad1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    loadValue = loadValue + 1;
                } else {
                    loadValue = loadValue - 1;
                }
            }
        });

        // Check Coupling Radio
        couplingGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.reba_wrist_coupling_radio1:
                        couplingRadio = 0;
                        break;
                    case R.id.reba_wrist_coupling_radio2:
                        couplingRadio = 1;
                        break;
                    case R.id.reba_wrist_coupling_radio3:
                        couplingRadio = 2;
                        break;
                    case R.id.reba_wrist_coupling_radio4:
                        couplingRadio = 3;
                        break;
                }
            }
        });
        couplingValue = couplingValue + couplingRadio;

        // Check Activity CheckBox
        activity1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    activityValue = activityValue + 1;
                } else {
                    activityValue = activityValue + 1;
                }
            }
        });

        activity2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    activityValue = activityValue + 1;
                } else {
                    activityValue = activityValue + 1;
                }
            }
        });

        activity3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    activityValue = activityValue + 1;
                } else {
                    activityValue = activityValue + 1;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_wrist, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_wrist_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.reba_wrist_next:
                Intent intent = new Intent(RebaWristActivity.this, ResultRebaActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}