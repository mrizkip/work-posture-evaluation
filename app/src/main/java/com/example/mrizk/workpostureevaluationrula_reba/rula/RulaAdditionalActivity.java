package com.example.mrizk.workpostureevaluationrula_reba.rula;

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

public class RulaAdditionalActivity extends AppCompatActivity {

    private static final String TAG = "RulaAdditionalPartAActi";

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

    private int armAndWristMuscleCheck = 0;
    private int armAndWristMuscleValue = 0;

    private int armAndWristLoadRadio = 0;
    private int armAndWristLoadValue = 0;

    private int neckTrunkLegsMuscleCheck = 0;
    private int neckTrunkLegsMuscleValue = 0;

    private int neckTrunkLegsLoadRadio;
    private int neckTrunkLegsLoadValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_additional);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA ADDITIONAL 1");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Check ArmAndWristMuscle
        armAndWristMuscle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    armAndWristMuscleCheck = armAndWristMuscleCheck + 1;
                } else {
                    armAndWristMuscleCheck = armAndWristMuscleCheck - 1;
                }
            }
        });
        armAndWristMuscleValue = armAndWristMuscleValue + armAndWristMuscleCheck;

        // Check ArmAndWristRadio
        armAndWristLoadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
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
            }
        });
        armAndWristLoadValue = armAndWristLoadValue + armAndWristLoadRadio;

        // Check Neck, Trunk, Legs Muscle CheckBox
        neckTrunkLegsMuscle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckTrunkLegsMuscleCheck = neckTrunkLegsMuscleCheck + 1;
                } else {
                    neckTrunkLegsMuscleCheck = neckTrunkLegsMuscleCheck - 1;
                }
            }
        });
        neckTrunkLegsMuscleValue = neckTrunkLegsMuscleValue + neckTrunkLegsMuscleCheck;

        // Check Neck, Trunk, Legs Load
        neckTrunkLegsLoadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
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
            }
        });
        neckTrunkLegsLoadValue = neckTrunkLegsLoadValue + neckTrunkLegsLoadRadio;

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
                Intent intent = new Intent(RulaAdditionalActivity.this, ResultRulaActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
