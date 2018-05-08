package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.main.MainActivity;
import com.example.mrizk.workpostureevaluationrula_reba.rula.ResultRulaActivity;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaA;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaB;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaC;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableA;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableB;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRebaActivity extends AppCompatActivity {

    private static final String TAG = "ResultRebaActivity";

    @BindView(R.id.result_reba_toolbar)
    Toolbar toolbar;
    @BindView(R.id.result_reba_tvNeckScore)
    TextView tvNeckScore;
    @BindView(R.id.result_reba_tvTrunkScore)
    TextView tvTrunkScore;
    @BindView(R.id.result_reba_tvUpperArmScore)
    TextView tvUpperArmScore;
    @BindView(R.id.result_reba_tvLowerArmScore)
    TextView tvLowerArmScore;
    @BindView(R.id.result_reba_tvWristScore)
    TextView tvWristScore;
    @BindView(R.id.result_reba_tvLegsScore)
    TextView tvLegsScore;
    @BindView(R.id.result_reba_tvTotalScore)
    TextView tvTotalScore;
    @BindView(R.id.result_reba_partHighScore)
    TextView tvPartHighScore;
    @BindView(R.id.result_reba_imvSudut)
    ImageView imvResult;
    @BindView(R.id.result_reba_sideView)
    ImageView menuSideView;
    @BindView(R.id.result_reba_save)
    ImageView menuSave;
    @BindView(R.id.result_reba_healthCare)
    ImageView menuHealthCare;
    @BindView(R.id.result_reba_home)
    ImageView menuHome;

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

    private Bitmap bmpResult;
    private String pathImage;

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
        pathImage = intent.getStringExtra("bmpResult");

        // Calculate result
        mapKeyRebaA = new MapKeyRebaA(trunkScore, neckScore, legsScore);
        mapKeyRebaB = new MapKeyRebaB(upperArmScore, lowerArmScore, wristScore);

        if (mapTableA.containsKey(mapKeyRebaA)) {
            postureScoreA = mapTableA.get(mapKeyRebaA);
        } else {
            postureScoreA = 0;
        }

        if (mapTableB.containsKey(mapKeyRebaB)) {
            postureScoreB = mapTableB.get(mapKeyRebaB);
        } else {
            postureScoreB = 0;
        }

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
        finalScore = tableCScore + activityScore;

        String stringHighScoreName = calculateMaxScore();

        // set text
        tvNeckScore.setText("Neck Score: " + String.valueOf(neckScore));
        tvTrunkScore.setText("Trunk Score: " + String.valueOf(trunkScore));
        tvUpperArmScore.setText("Upper Arm Score: " + String.valueOf(upperArmScore));
        tvLowerArmScore.setText("Lower Arm Score: " + String.valueOf(lowerArmScore));
        tvWristScore.setText("Wrist Score: " + wristScore);
        tvLegsScore.setText("Legs Score: " + legsScore);
        tvTotalScore.setText("Total Score: " + finalScore);
        tvPartHighScore.setText(stringHighScoreName);

        // set Image
        loadImageFromStorage(pathImage);

        // set on click menu
        menuSideView.setOnClickListener(view -> sideView());
        menuSave.setOnClickListener(view -> saveScreen());
        menuHealthCare.setOnClickListener(view -> healthCare());
        menuHome.setOnClickListener(view -> home());
    }

    private void home() {
        Intent intent = new Intent(ResultRebaActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void healthCare() {

    }

    private void saveScreen() {

    }

    private void sideView() {

    }

    private String calculateMaxScore() {
        int maxScore = 0;
        String maxName = "";

        if (neckScore > maxScore) {
            maxScore = neckScore;
            maxName = "Neck";
        }
        if (trunkScore > maxScore) {
            maxScore = trunkScore;
            maxName = "Trunk";
        }
        if (upperArmScore > maxScore) {
            maxScore = upperArmScore;
            maxName = "Upper Arm";
        }
        if (lowerArmScore > maxScore) {
            maxScore = lowerArmScore;
            maxName = "Lower Arm";
        }
        if (wristScore > maxScore) {
            maxScore = wristScore;
            maxName = "Wrist";
        }
        if (legsScore > maxScore) {
            maxScore = legsScore;
            maxName = "Legs";
        }

        return maxName;
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

    private void loadImageFromStorage(String path) {

        try {
            File f = new File(path);
            bmpResult = BitmapFactory.decodeStream(new FileInputStream(f));
            imvResult.setImageBitmap(bmpResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
