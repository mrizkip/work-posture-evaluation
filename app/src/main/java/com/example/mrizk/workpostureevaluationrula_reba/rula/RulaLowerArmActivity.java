package com.example.mrizk.workpostureevaluationrula_reba.rula;

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
    @BindView(R.id.rula_lowerArm_leg_radioGroup)
    RadioGroup legsGroup;

    @BindView(R.id.rula_lowerArm_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;
    private int lowerArmValue = 0;
    private int lowerArmPosition;
    private int wristValue = 0;
    private int wristPosition;
    private int wristTwistRadio;
    private int wristTwistValue = 0;
    private int legsRadio;
    private int legsValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_lower_arm);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA LOWER ARM");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get Intent and Place Image
        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);

        // Check LowerArm CheckBox
        lowerArmValue = lowerArmValue + lowerArmPosition;
        lowerArm1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    lowerArmValue = lowerArmValue + 1;
                } else {
                    lowerArmValue = lowerArmValue - 1;
                }
            }
        });

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

        // Check WristTwist
        wristTwistGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rula_lowerArm_wristTwist_radio1:
                        wristTwistRadio = 1;
                        break;
                    case R.id.rula_lowerArm_wristTwist_radio2:
                        wristTwistRadio = 2;
                        break;
                }
            }
        });
        wristTwistValue = wristTwistValue + wristTwistRadio;

        // Check Legs RadioButton
        legsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rula_lowerArm_leg_radio1:
                        legsRadio = 1;
                        break;
                    case  R.id.rula_lowerArm_leg_radio2:
                        legsRadio = 2;
                        break;
                }
            }
        });
        legsValue = legsValue + legsRadio;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_lower_arm, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_lower_arm_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.rula_upper_arm_neck_trunk_next:
                Intent intent = new Intent(RulaLowerArmActivity.this, RulaAdditionalActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
