package com.example.mrizk.workpostureevaluationrula_reba;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RulaAdditionalPartBActivity extends AppCompatActivity {

    @BindView(R.id.rulaAdd2_toolbar)
    Toolbar toolbar;
    ActionBar actionBar;

    @BindView(R.id.rulaAdd2_Neck_check1)
    CheckBox neck1;
    @BindView(R.id.rulaAdd2_Neck_check2)
    CheckBox neck2;

    @BindView(R.id.rulaAdd2_Trunk_check1)
    CheckBox trunk1;
    @BindView(R.id.rulaAdd2_Trunk_check2)
    CheckBox trunk2;

    @BindView(R.id.rulaAdd2_leg_radioGroup)
    RadioGroup legsGroup;
    @BindView(R.id.rulaAdd2_leg_radio1)
    RadioButton legs1;
    @BindView(R.id.rulaAdd2_leg_radio2)
    RadioButton legs2;

    @BindView(R.id.rulaAdd2_Muscle_check1)
    CheckBox neckTrunkLegsMuscle1;

    @BindView(R.id.rulaAdd2_load_radioGroup)
    RadioGroup neckTrunkLegsLoadGroup;
    @BindView(R.id.rulaAdd2_load_radio1)
    RadioButton neckTrunkLegsLoad1;
    @BindView(R.id.rulaAdd2_load_radio2)
    RadioButton neckTrunkLegsLoad2;
    @BindView(R.id.rulaAdd2_load_radio3)
    RadioButton neckTrunkLegsLoad3;
    @BindView(R.id.rulaAdd2_load_radio4)
    RadioButton neckTrunkLegsLoad4;

    private int neckPosition;
    private int neckValue = 0;

    private int trunkPosition;
    private int trunkValue = 0;

    private int legsRadio = 0;
    private int legsValue = 0;

    private int neckTrunkLegsMuscleCheck = 0;
    private int neckTrunkLegsMuscleValue = 0;

    private int neckTrunkLegsLoadRadio = 0;
    private int neckTrunkLegsLoadValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_additional_part_b);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA ADDITIONAL 2");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Check Neck CheckBox
        neckValue = neckValue + neckPosition;
        neck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckValue = neckValue + 1;
                } else {
                    neckValue = neckValue - 1;
                }
            }
        });

        neck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckValue = neckValue + 1;
                } else {
                    neckValue = neckValue - 1;
                }
            }
        });

        // Check Trunk CheckBox
        trunkValue = trunkValue + trunkPosition;
        trunk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    trunkValue = trunkValue + 1;
                } else {
                    trunkValue = trunkValue - 1;
                }
            }
        });

        trunk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    trunkValue = trunkValue + 1;
                } else {
                    trunkValue = trunkValue - 1;
                }
            }
        });

        // Check Legs RadioButton
        legsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rulaAdd2_leg_radio1:
                        legsRadio = 1;
                    case  R.id.rulaAdd2_leg_radio2:
                        legsRadio = 2;
                }
            }
        });
        legsValue = legsValue + legsRadio;

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
                    case R.id.rulaAdd2_load_radio1:
                        neckTrunkLegsLoadRadio = 0;
                    case R.id.rulaAdd2_load_radio2:
                        neckTrunkLegsLoadRadio = 1;
                    case R.id.rulaAdd2_load_radio3:
                        neckTrunkLegsLoadRadio = 2;
                    case R.id.rulaAdd2_load_radio4:
                        neckTrunkLegsLoadRadio = 3;
                }
            }
        });
        neckTrunkLegsLoadValue = neckTrunkLegsLoadValue + neckTrunkLegsLoadRadio;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_add_part_b, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_add2_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.rula_add2_next:
                Intent intent = new Intent(RulaAdditionalPartBActivity.this, ResultRulaActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
