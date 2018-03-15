package com.example.mrizk.workpostureevaluationrula_reba;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RulaAdditionalPartAActivity extends AppCompatActivity {

    private static final String TAG = "RulaAdditionalPartAActi";

    @BindView(R.id.rulaAdd1_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @BindView(R.id.rulaAdd1_upperArm_check1)
    CheckBox upperArm1;
    @BindView(R.id.rulaAdd1_upperArm_check2)
    CheckBox upperArm2;
    @BindView(R.id.rulaAdd1_upperArm_check3)
    CheckBox upperArm3;

    @BindView(R.id.rulaAdd1_lowerArm_check1)
    CheckBox lowerArm1;

    @BindView(R.id.rulaAdd1_wrist_check1)
    CheckBox wrist1;

    @BindView(R.id.rulaAdd1_wristTwist_radioGroup)
    RadioGroup wristTwistGroup;
    @BindView(R.id.rulaAdd1_wristTwist_radio1)
    RadioButton wristTwist1;
    @BindView(R.id.rulaAdd1_wristTwist_radio2)
    RadioButton wristTwist2;

    @BindView(R.id.rulaAdd1_muscle_check1)
    CheckBox armAndWristMuscle1;

    @BindView(R.id.rulaAdd1_radioGroupLoad)
    RadioGroup armAndWristLoadGroup;
    @BindView(R.id.rulaAdd1_load_radio1)
    RadioButton armAndWristLoad1;
    @BindView(R.id.rulaAdd1_load_radio2)
    RadioButton armAndWristLoad2;
    @BindView(R.id.rulaAdd1_load_radio3)
    RadioButton armAndWristLoad3;
    @BindView(R.id.rulaAdd1_load_radio4)
    RadioButton armAndWristLoad4;

    private int upperArmPosition;
    private int upperArmValue = 0;

    private int lowerArmPosition;
    private int lowerArmValue = 0;

    private int wristPosition;
    private int wristValue = 0;

    private int wristTwistRadio = 0;
    private int wristTwistValue;

    private int armAndWristMuscleCheck = 0;
    private int armAndWristMuscleValue;

    private int armAndWristLoadRadio = 0;
    private int armAndWristLoadValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_additional_part_a);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA ADDITIONAL 1");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Check UpperArm CheckBox
        upperArmValue = upperArmValue + upperArmPosition;
        upperArm1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue + 1;
                } else {
                    upperArmValue = upperArmValue - 1;
                }
            }
        });

        upperArm2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue + 1;
                } else {
                    upperArmValue = upperArmValue - 1;
                }
            }
        });

        upperArm3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue - 1;
                } else {
                    upperArmValue = upperArmValue + 1;
                }
            }
        });

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
                    case R.id.rulaAdd1_wristTwist_radio1:
                        wristTwistRadio = 1;
                        break;
                    case R.id.rulaAdd1_wristTwist_radio2:
                        wristTwistRadio = 2;
                        break;
                    default:
                        wristTwistRadio = 0;
                        break;
                }
            }
        });
        wristTwistValue = wristTwistValue + wristTwistRadio;

        // Check ArmAndWristMuscle
        armAndWristMuscle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    armAndWristMuscleCheck = armAndWristMuscleCheck + 1;
                } else {
                    armAndWristMuscleCheck = armAndWristMuscleCheck + 1;
                }
            }
        });
        armAndWristMuscleValue = armAndWristMuscleValue + armAndWristMuscleCheck;

        // Check ArmAndWristRadio
        armAndWristLoadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rulaAdd1_load_radio1:
                        armAndWristLoadRadio = 0;
                        break;
                    case R.id.rulaAdd1_load_radio2:
                        armAndWristLoadRadio = 1;
                        break;
                    case R.id.rulaAdd1_load_radio3:
                        armAndWristLoadRadio = 2;
                        break;
                    case R.id.rulaAdd1_load_radio4:
                        armAndWristLoadRadio = 3;
                        break;
                }
            }
        });
        armAndWristLoadValue = armAndWristLoadValue + armAndWristLoadRadio;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_add_part_a, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_add1_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.rula_add1_next:
                Intent intent = new Intent(RulaAdditionalPartAActivity.this, RulaAdditionalPartBActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
