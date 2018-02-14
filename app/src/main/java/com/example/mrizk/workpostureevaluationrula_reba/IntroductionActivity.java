package com.example.mrizk.workpostureevaluationrula_reba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionActivity extends AppCompatActivity {

    @BindView(R.id.intro_imageView)
    ImageView imageViewIntro;
    @BindView(R.id.intro_buttonReba)
    Button buttonReba;
    @BindView(R.id.intro_buttonRula)
    Button buttonRula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        ButterKnife.bind(this);

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
}
