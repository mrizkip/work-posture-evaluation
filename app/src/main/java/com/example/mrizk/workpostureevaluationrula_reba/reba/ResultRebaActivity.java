package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.main.MainActivity;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaA;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaB;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaC;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableA;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableB;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableC;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRebaActivity extends AppCompatActivity {

    private static final String TAG = "ResultRebaActivity";

    @BindView(R.id.result_reba_toolbar)
    Toolbar toolbar;
    @BindView(R.id.result_reba_buttonStart)
    Button buttonStart;
    @BindView(R.id.result_reba_tvScoreA)
    TextView tvScoreA;
    @BindView(R.id.result_reba_tvLoadScore)
    TextView tvLoadScore;
    @BindView(R.id.result_reba_tvScoreB)
    TextView tvScoreB;
    @BindView(R.id.result_reba_tvCouplingScore)
    TextView tvCouplingScore;
    @BindView(R.id.result_reba_tvActivityScore)
    TextView tvActivityScore;
    @BindView(R.id.result_reba_tvFinalScore)
    TextView tvFinalScore;

    ActionBar actionBar;

    private int trunkScore;
    private int neckScore;
    private int upperArmScore;
    private int lowerArmScore;
    private int wristScore;
    private int legsScore;
    private int loadScore;
    private int couplingScore;
    private int activityScore;

    private Map<MapKeyRebaA, Integer> mapTableA;
    private Map<MapKeyRebaB, Integer> mapTableB;
    private Map<MapKeyRebaC, Integer> mapTableC;

    private MapKeyRebaA mapKeyRebaA;
    private MapKeyRebaB mapKeyRebaB;
    private MapKeyRebaC mapKeyRebaC;

    private int postureScoreA;
    private int postureScoreB;
    private int scoreA;
    private int scoreB;
    private int finalScore;

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

        // init table
        initTableA();
        initTableB();
        initTableC();

        // get Intent
        Intent intent = getIntent();
        trunkScore = intent.getIntExtra("trunkScore", 0);
        neckScore = intent.getIntExtra("neckScore", 0);
        upperArmScore = intent.getIntExtra("upperArmScore", 0);
        lowerArmScore = intent.getIntExtra("lowerArmScore", 0);
        wristScore = intent.getIntExtra("wristScore", 0);
        legsScore = intent.getIntExtra("legsScore", 0);
        loadScore = intent.getIntExtra("loadScore", 0);
        couplingScore = intent.getIntExtra("couplingScore", 0);
        activityScore = intent.getIntExtra("activityScore", 0);

        Log.d(TAG, "onCreate: trunkScore: " + trunkScore);
        Log.d(TAG, "onCreate: neckScore: " + neckScore);
        Log.d(TAG, "onCreate: upperArmScore: " + upperArmScore);
        Log.d(TAG, "onCreate: lowerArmScore: " + lowerArmScore);
        Log.d(TAG, "onCreate: wristScore: " + wristScore);
        Log.d(TAG, "onCreate: legsScore: " + legsScore);
        Log.d(TAG, "onCreate: loadScore: " + loadScore);
        Log.d(TAG, "onCreate: couplingScore: " + couplingScore);
        Log.d(TAG, "onCreate: activityScore: " + activityScore);

        // Calculate result
        mapKeyRebaA = new MapKeyRebaA(trunkScore, neckScore, legsScore);
        mapKeyRebaB = new MapKeyRebaB(upperArmScore, lowerArmScore, wristScore);

        if (mapTableA.containsKey(mapKeyRebaA)) {
            postureScoreA = mapTableA.get(mapKeyRebaA);
        } else {
            postureScoreA = 0;
        }
        Log.d(TAG, "onCreate: Posture Score A: " + postureScoreA);

        if (mapTableB.containsKey(mapKeyRebaB)) {
            postureScoreB = mapTableB.get(mapKeyRebaB);
        } else {
            postureScoreB = 0;
        }
        Log.d(TAG, "onCreate: Posture Score B: " + postureScoreB);

        scoreA = postureScoreA + loadScore;
        scoreB = postureScoreB + couplingScore;
        mapKeyRebaC = new MapKeyRebaC(scoreA, scoreB);

        // final score
        int tableCScore;
        if (mapTableC.containsKey(mapKeyRebaC)) {
            tableCScore = mapTableC.get(mapKeyRebaC);
        } else {
            tableCScore = 0;
        }
        finalScore = tableCScore + couplingScore;
        Log.d(TAG, "onCreate: Table C Score: " + tableCScore);
        Log.d(TAG, "onCreate: Final Score: " + finalScore);

        tvScoreA.setText("Posture Score A: " + String.valueOf(postureScoreA));
        tvLoadScore.setText("Load Score: " + String.valueOf(loadScore));
        tvScoreB.setText("Posture Score B: " + String.valueOf(postureScoreB));
        tvCouplingScore.setText("Coupling Score: " + String.valueOf(couplingScore));
        tvActivityScore.setText("Activity Score: " + String.valueOf(activityScore));
        tvFinalScore.setText("Final Score: " + String.valueOf(finalScore));

        // Home
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultRebaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initTableA() {
        RebaTableA rebaTableA = new RebaTableA();
        mapTableA = rebaTableA.getMapTableA();
    }

    private void initTableB() {
        RebaTableB rebaTableB = new RebaTableB();
        mapTableB = rebaTableB.getMapTableB();
    }

    private void initTableC() {
        RebaTableC rebaTableC = new RebaTableC();
        mapTableC = rebaTableC.getMapTableC();
    }
}
