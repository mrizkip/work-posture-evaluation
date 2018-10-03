package com.example.mrizk.workpostureevaluationrula_reba.rula;

import android.content.Intent;
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
import android.widget.RadioGroup;

import com.example.mrizk.workpostureevaluationrula_reba.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RulaAdditionalActivity extends AppCompatActivity {

    @BindView(R.id.rulaAdd1_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @BindView(R.id.rulaAdd_arm_wrist_muscle_check1)
    CheckBox armAndWristMuscle1;
    @BindView(R.id.rulaAdd_arm_wrist_radioGroupLoad)
    RadioGroup armAndWristLoadGroup;
    @BindView(R.id.rulaAdd_neck_trunk_legs_Muscle_check1)
    CheckBox neckTrunkLegsMuscle1;
    @BindView(R.id.rulaAdd_neck_trunk_legs_load_radioGroup)
    RadioGroup neckTrunkLegsLoadGroup;

    private int armAndWristMuscleValue = 0;

    private int armAndWristLoadRadio = 0;
    private int armAndWristLoadValue = 0;

    private int neckTrunkLegsMuscleValue = 0;

    private int neckTrunkLegsLoadRadio;
    private int neckTrunkLegsLoadValue = 0;

    private int neckScore;
    private int trunkScore;
    private int upperArmScore;
    private int lowerArmScore;
    private int wristScore;
    private int wristTwistScore;
    private int legsScore;

    private String bmpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_additional);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA Additional");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get intent
        Intent intent = getIntent();
        neckScore = intent.getIntExtra("neckScore", 0);
        trunkScore = intent.getIntExtra("trunkScore", 0);
        upperArmScore = intent.getIntExtra("upperArmScore", 0);
        legsScore = intent.getIntExtra("legsScore", 0);
        lowerArmScore = intent.getIntExtra("lowerArmScore", 0);
        wristScore = intent.getIntExtra("wristScore", 0);
        wristTwistScore = intent.getIntExtra("wristTwistScore", 0);
        bmpResult = intent.getStringExtra("bmpResult");

        // Check ArmAndWristMuscle
        armAndWristMuscle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    armAndWristMuscleValue = armAndWristMuscleValue + 1;
                } else {
                    armAndWristMuscleValue = armAndWristMuscleValue - 1;
                }
            }
        });

        // Check Neck, Trunk, Legs Muscle CheckBox
        neckTrunkLegsMuscle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckTrunkLegsMuscleValue = neckTrunkLegsMuscleValue + 1;
                } else {
                    neckTrunkLegsMuscleValue = neckTrunkLegsMuscleValue - 1;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_add_part_a, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_add1_next);
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
            case R.id.rula_add1_next:
                // get arm and wrist radio
                int armWristRadioId = armAndWristLoadGroup.getCheckedRadioButtonId();
                switch (armWristRadioId) {
                    case R.id.rulaAdd_arm_wrist_load_radio1:
                        armAndWristLoadRadio = 0;
                        break;
                    case R.id.rulaAdd_arm_wrist_load_radio2:
                        armAndWristLoadRadio = 1;
                        break;
                    case R.id.rulaAdd_arm_wrist_load_radio3:
                        armAndWristLoadRadio = 2;
                        break;
                    case R.id.rulaAdd_arm_wrist_load_radio4:
                        armAndWristLoadRadio = 3;
                        break;
                }

                // get neck trunk legs radio
                int neckTrunkLegsRadioId = neckTrunkLegsLoadGroup.getCheckedRadioButtonId();
                switch (neckTrunkLegsRadioId) {
                    case R.id.rulaAdd_neck_trunk_legs_load_radio1:
                        neckTrunkLegsLoadRadio = 0;
                        break;
                    case R.id.rulaAdd_neck_trunk_legs_load_radio2:
                        neckTrunkLegsLoadRadio = 1;
                        break;
                    case R.id.rulaAdd_neck_trunk_legs_load_radio3:
                        neckTrunkLegsLoadRadio = 2;
                        break;
                    case R.id.rulaAdd_neck_trunk_legs_load_radio4:
                        neckTrunkLegsLoadRadio = 3;
                        break;
                }

                // create intent
                armAndWristLoadValue = armAndWristLoadValue + armAndWristLoadRadio;
                neckTrunkLegsLoadValue = neckTrunkLegsLoadValue + neckTrunkLegsLoadRadio;
                Intent intent = new Intent(RulaAdditionalActivity.this, ResultRulaActivity.class);
                intent.putExtra("legsScore", legsScore);
                intent.putExtra("upperArmScore", upperArmScore);
                intent.putExtra("neckScore", neckScore);
                intent.putExtra("trunkScore", trunkScore);
                intent.putExtra("lowerArmScore", lowerArmScore);
                intent.putExtra("wristScore", wristScore);
                intent.putExtra("wristTwistScore", wristTwistScore);
                intent.putExtra("armAndWristMuscleScore", armAndWristMuscleValue);
                intent.putExtra("armAndWristLoadScore", armAndWristLoadValue);
                intent.putExtra("neckTrunkLegsMuscleScore", neckTrunkLegsMuscleValue);
                intent.putExtra("neckTrunkLegsLoadScore", neckTrunkLegsLoadValue);
                intent.putExtra("bmpResult", bmpResult);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
