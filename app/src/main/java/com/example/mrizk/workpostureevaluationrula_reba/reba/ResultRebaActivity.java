package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.main.MainActivity;
import com.example.mrizk.workpostureevaluationrula_reba.util.DialogHealthCare;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaA;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaB;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRebaC;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableA;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableB;
import com.example.mrizk.workpostureevaluationrula_reba.util.RebaTableC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRebaActivity extends AppCompatActivity {

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
    @BindView(R.id.result_reba_keterangan1)
    TextView keterangan1;
    @BindView(R.id.result_reba_keterangan2)
    TextView keterangan2;
    @BindView(R.id.result_reba_keterangan3)
    TextView keterangan3;
    @BindView(R.id.result_reba_keterangan4)
    TextView keterangan4;
    @BindView(R.id.result_reba_keterangan5)
    TextView keterangan5;

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

        // set score
        String stringHighScoreName = calculateMaxScore();
        scoring();

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

    private void scoring() {
        // total score
        if (finalScore == 1) {
            keterangan1.setVisibility(View.VISIBLE);
        } else if (finalScore >= 2 && finalScore <= 3) {
            keterangan2.setVisibility(View.VISIBLE);
        } else if (finalScore >= 4 && finalScore <= 7) {
            keterangan3.setVisibility(View.VISIBLE);
        } else if (finalScore >= 8 && finalScore <= 10) {
            keterangan4.setVisibility(View.VISIBLE);
        } else if (finalScore >= 11) {
            keterangan5.setVisibility(View.VISIBLE);
        }
    }

    private void home() {
        Intent intent = new Intent(ResultRebaActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void healthCare() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogHealthCare newFragment = new DialogHealthCare();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();
    }

    private void saveScreen() {
        takeScreenshot();
        Toast.makeText(this, "Screenshot Saved!", Toast.LENGTH_SHORT).show();
    }

    private void sideView() {
        Intent intent = new Intent(ResultRebaActivity.this, RebaSideViewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(this, "Back to Side View", Toast.LENGTH_SHORT).show();
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

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/DCIM/Screenshots/" + now + ".jpg";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }
}
