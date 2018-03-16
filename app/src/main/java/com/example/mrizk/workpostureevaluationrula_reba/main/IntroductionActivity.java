package com.example.mrizk.workpostureevaluationrula_reba.main;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.reba.RebaActivity;
import com.example.mrizk.workpostureevaluationrula_reba.rula.RulaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionActivity extends AppCompatActivity {

    @BindView(R.id.intro_toolbar)
    Toolbar toolbar;
    @BindView(R.id.intro_imageView)
    ImageView imageViewIntro;
    @BindView(R.id.intro_buttonReba)
    Button buttonReba;
    @BindView(R.id.intro_buttonRula)
    Button buttonRula;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("INTRODUCTION");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        buttonRula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroductionActivity.this, RulaActivity.class);
                startActivity(intent);
            }
        });

        buttonReba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroductionActivity.this, RebaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
