package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.reba_wrist_imvWristBend)
    ImageView imvWristBend;

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

    private int trunkScore;
    private int neckScore;
    private int upperArmScore;
    private int lowerArmScore;
    private int legsScore;

    private String bmpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_wrist);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Top View");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // add drawable right
        addDrawableRight();

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);
        trunkScore = intent.getIntExtra("trunkScore", 0);
        neckScore = intent.getIntExtra("neckScore", 0);
        upperArmScore = intent.getIntExtra("upperArmScore", 0);
        lowerArmScore = intent.getIntExtra("lowerArmScore", 0);
        wristPosition = intent.getIntExtra("wristPosition", 0);
        legsScore = intent.getIntExtra("legsScore", 0);
        bmpResult = intent.getStringExtra("bmpResult");

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

        // Check Load CheckBox
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

    private void addDrawableRight() {
        // wrist
        Picasso.get().load("file:///android_asset/wrist_bent.png").resize(800, 800).into(imvWristBend);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_wrist, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_wrist_next);
        Drawable drawable = itemNext.getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.reba_wrist_next:
                // get radio button value
                int loadRadioId = wristLoadGroup.getCheckedRadioButtonId();
                switch (loadRadioId) {
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
                loadValue = loadValue + loadRadio;

                int couplingRadioId = couplingGroup.getCheckedRadioButtonId();
                switch (couplingRadioId) {
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
                couplingValue = couplingValue + couplingRadio;

                Intent intent = new Intent(RebaWristActivity.this, ResultRebaActivity.class);
                intent.putExtra("trunkScore", trunkScore);
                intent.putExtra("neckScore", neckScore);
                intent.putExtra("upperArmScore", upperArmScore);
                intent.putExtra("lowerArmScore", lowerArmScore);
                intent.putExtra("wristScore", wristValue);
                intent.putExtra("legsScore", legsScore);
                intent.putExtra("loadScore", loadValue);
                intent.putExtra("couplingScore", couplingValue);
                intent.putExtra("activityScore", activityValue);
                intent.putExtra("bmpResult", bmpResult);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
