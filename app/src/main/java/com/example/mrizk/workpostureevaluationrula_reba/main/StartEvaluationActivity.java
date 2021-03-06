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
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartEvaluationActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_start_evaluation);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Method Selection");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Picasso.get().load("file:///android_asset/guide_methode.png").into(imageViewIntro);

        buttonRula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartEvaluationActivity.this, RulaActivity.class);
                startActivity(intent);
            }
        });

        buttonReba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartEvaluationActivity.this, RebaActivity.class);
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
