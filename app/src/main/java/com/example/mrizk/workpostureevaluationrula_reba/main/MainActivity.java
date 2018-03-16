package com.example.mrizk.workpostureevaluationrula_reba.main;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.mrizk.workpostureevaluationrula_reba.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainActivity_toolbar)
    Toolbar toolbar;
    @BindView(R.id.mainActivity_buttonIntroduction)
    Button buttonIntroduce;
    @BindView(R.id.mainActivity_buttonAbout)
    Button buttonAbout;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("WORK POSTURE EVALUATION");
        }

        buttonIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
                startActivity(intent);
            }
        });

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
