package com.example.mrizk.workpostureevaluationrula_reba.rula;

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
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RulaLowerArmActivity extends AppCompatActivity {

    @BindView(R.id.rula_lowerArm_imageView)
    ImageView imageView;
    @BindView(R.id.rula_lowerArm_check1)
    CheckBox lowerArm1;
    @BindView(R.id.rula_lowerArm_wrist_check1)
    CheckBox wrist1;
    @BindView(R.id.rula_lowerArm_wristTwist_radioGroup)
    RadioGroup wristTwistGroup;
    @BindView(R.id.rula_lowerArm_ivCheck1)
    ImageView ivLowerArm1;
    @BindView(R.id.rula_wrist_ivCheck1)
    ImageView ivWrist1;
    @BindView(R.id.rula_lowerArm_wristTwist_ivRadio)
    ImageView ivWristTwist1;

    @BindView(R.id.rula_lowerArm_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;
    private int lowerArmValue = 0;
    private int lowerArmPosition;
    private int wristValue = 0;
    private int wristPosition;
    private int wristTwistRadio;
    private int wristTwistValue = 0;

    private int neckScore;
    private int trunkScore;
    private int upperArmScore;
    private int legsScore;

    private String bmpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_lower_arm);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Top View");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // add drawable right
        addDrawableRight();

        // Get Intent and Place Image
        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);
        neckScore = intent.getIntExtra("neckScore", 0);
        trunkScore = intent.getIntExtra("trunkScore", 0);
        upperArmScore = intent.getIntExtra("upperArmScore", 0);
        legsScore = intent.getIntExtra("legsScore", 0);
        lowerArmPosition = intent.getIntExtra("lowerArmPosition", 0);
        wristPosition = intent.getIntExtra("wristPosition", 0);
        bmpResult = intent.getStringExtra("bmpResult");

        // Check LowerArm CheckBox
        lowerArmValue = lowerArmValue + lowerArmPosition;
        lowerArm1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                lowerArmValue = lowerArmValue + 1;
            } else {
                lowerArmValue = lowerArmValue - 1;
            }
        });

        // Check Wrist CheckBox
        wristValue = wristValue + wristPosition;
        wrist1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                wristValue = wristValue + 1;
            } else {
                wristValue = wristValue - 1;
            }
        });

    }

    private void addDrawableRight() {
        // lower arm
        Picasso.get().load("file:///android_asset/shoulder_raised.png").resize(800, 800).into(ivLowerArm1);

        // wrist
        Picasso.get().load("file:///android_asset/wrist_bent.png").resize(800, 800).into(ivWrist1);

        // wrist twist
        Picasso.get().load("file:///android_asset/neck_extention.png").resize(800, 800).into(ivWristTwist1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_lower_arm, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_lower_arm_next);
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
            case R.id.rula_lower_arm_next:
                // get wrist twist score
                int wristRadioId = wristTwistGroup.getCheckedRadioButtonId();
                switch (wristRadioId) {
                    case R.id.rula_lowerArm_wristTwist_radio1:
                        wristTwistRadio = 1;
                        break;
                    case R.id.rula_lowerArm_wristTwist_radio2:
                        wristTwistRadio = 2;
                        break;
                }

                wristTwistValue = wristTwistValue + wristTwistRadio;
                Intent intent = new Intent(RulaLowerArmActivity.this, RulaAdditionalActivity.class);
                intent.putExtra("legsScore", legsScore);
                intent.putExtra("upperArmScore", upperArmScore);
                intent.putExtra("neckScore", neckScore);
                intent.putExtra("trunkScore", trunkScore);
                intent.putExtra("lowerArmScore", lowerArmValue);
                intent.putExtra("wristScore", wristValue);
                intent.putExtra("wristTwistScore", wristTwistValue);
                intent.putExtra("bmpResult", bmpResult);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
