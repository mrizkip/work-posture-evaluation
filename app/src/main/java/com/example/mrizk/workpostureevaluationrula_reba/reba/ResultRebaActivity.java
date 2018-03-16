package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRebaActivity extends AppCompatActivity {

    @BindView(R.id.result_reba_toolbar)
    Toolbar toolbar;
    @BindView(R.id.result_reba_buttonStart)
    Button buttonStart;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_reba);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RESULT REBA");
        }

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultRebaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
