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

public class RebaAdditionalPartAActivity extends AppCompatActivity {

    @BindView(R.id.rebaAdd1_Neck_check1)
    CheckBox neck1;
    @BindView(R.id.rebaAdd1_Neck_check2)
    CheckBox neck2;
    @BindView(R.id.rebaAdd1_Trunk_check1)
    CheckBox trunk1;
    @BindView(R.id.rebaAdd1_Trunk_check2)
    CheckBox trunk2;
    @BindView(R.id.rebaAdd1_leg_radioGroup)
    RadioGroup legsRadioGroup;
    @BindView(R.id.rebaAdd1_leg_check1)
    CheckBox legsCheck1;
    @BindView(R.id.rebaAdd1_leg_check2)
    CheckBox legsCheck2;
    @BindView(R.id.rebaAdd1_load_radioGroup)
    RadioGroup loadRadioGroup;
    @BindView(R.id.rebaAdd1_load_check1)
    CheckBox loadCheck1;

    @BindView(R.id.rebaAdd1_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;

    private int neckPosition;
    private int neckValue = 0;
    private int trunkPosition;
    private int trunkValue = 0;
    private int legsPosition;
    private int legsRadio = 0;
    private int legsValue = 0;
    private int loadRadio = 0;
    private int loadValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_additional_part_a);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("REBA ADDITIONAL 1");
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

        // Check Legs Radio and CheckBox
        legsValue = legsValue + legsPosition;
        legsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rebaAdd1_leg_radio1:
                        legsRadio = 1;
                        break;
                    case R.id.rebaAdd1_leg_radio2:
                        legsRadio = 2;
                        break;
                }
            }
        });
        legsValue = legsValue + legsRadio;

        legsCheck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    legsValue = legsValue + 1;
                } else {
                    legsValue = legsValue - 1;
                }
            }
        });

        legsCheck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (b) {
                        legsValue = legsValue + 2;
                    } else {
                        legsValue = legsValue - 2;
                    }
                }
            }
        });

        // Check Load RadioGroup and CheckBox
        loadRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rebaAdd1_load_radio1:
                        loadRadio = 0;
                        break;
                    case R.id.rebaAdd1_load_radio2:
                        loadRadio = 1;
                        break;
                    case R.id.rebaAdd1_load_radio3:
                        loadRadio = 2;
                        break;
                }
            }
        });
        loadValue = loadValue + loadRadio;

        loadCheck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    loadValue = loadValue + 1;
                } else {
                    loadValue = loadValue - 1;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_add_part_a, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_add1_next);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.reba_add1_next:
                Intent intent = new Intent(RebaAdditionalPartAActivity.this, RebaAdditionalPartBActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
