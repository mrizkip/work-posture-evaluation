package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RebaAdditionalPartBActivity extends AppCompatActivity {

    @BindView(R.id.rebaAdd2_upperArm_check1)
    CheckBox upperArm1;
    @BindView(R.id.rebaAdd2_upperArm_check2)
    CheckBox upperArm2;
    @BindView(R.id.rebaAdd2_upperArm_check3)
    CheckBox upperArm3;
    @BindView(R.id.rebaAdd2_wrist_check1)
    CheckBox wrist1;
    @BindView(R.id.rebaAdd2_coupling_radioGroup)
    RadioGroup couplingRadioGroup;
    @BindView(R.id.rebaAdd2_activity_check1)
    CheckBox activity1;
    @BindView(R.id.rebaAdd2_activity_check2)
    CheckBox activity2;
    @BindView(R.id.rebaAdd2_activity_check3)
    CheckBox activity3;

    @BindView(R.id.rebaAdd2_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    private int upperArmPosition;
    private int upperArmValue = 0;
    private int lowerArmPosition;
    private int lowerArmValue = 0;
    private int wristPosition;
    private int wristValue = 0;
    private int couplingRadio;
    private int couplingValue = 0;
    private int activityValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_additional_part_b);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("REBA ADDITIONAL 2");
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

        // Check LowerArm Position
        lowerArmValue = lowerArmValue + lowerArmPosition;

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

        // Check Coupling Radio
        couplingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rebaAdd2_coupling_radio1:
                        couplingRadio = 0;
                        break;
                    case R.id.rebaAdd2_coupling_radio2:
                        couplingRadio = 1;
                        break;
                    case R.id.rebaAdd2_coupling_radio3:
                        couplingRadio = 2;
                        break;
                    case R.id.rebaAdd2_coupling_radio4:
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
        inflater.inflate(R.menu.menu_reba_add_part_b, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_add2_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.reba_add2_next:
                Intent intent = new Intent(RebaAdditionalPartBActivity.this, ResultRebaActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
