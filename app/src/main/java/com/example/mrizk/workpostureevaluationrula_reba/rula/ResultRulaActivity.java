package com.example.mrizk.workpostureevaluationrula_reba.rula;

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
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRulaA;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRulaB;
import com.example.mrizk.workpostureevaluationrula_reba.util.RulaTableA;
import com.example.mrizk.workpostureevaluationrula_reba.util.RulaTableB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRulaActivity extends AppCompatActivity {

    private static final String TAG = "ResultRulaActivity";

    @BindView(R.id.result_rula_toolbar)
    Toolbar toolbar;
    @BindView(R.id.result_rula_tvNeckScore)
    TextView tvNeckScore;
    @BindView(R.id.result_rula_tvTrunkScore)
    TextView tvTrunkScore;
    @BindView(R.id.result_rula_tvUpperArmScore)
    TextView tvUpperArmScore;
    @BindView(R.id.result_rula_tvLowerArmScore)
    TextView tvLowerArmScore;
    @BindView(R.id.result_rula_tvWristScore)
    TextView tvWristScore;
    @BindView(R.id.result_rula_tvTotalScore)
    TextView tvTotalScore;
    @BindView(R.id.result_rula_partHighScore)
    TextView tvPartHighScore;
    @BindView(R.id.result_rula_imvSudut)
    ImageView imvResult;
    @BindView(R.id.result_rula_sideView)
    ImageView menuSideView;
    @BindView(R.id.result_rula_save)
    ImageView menuSave;
    @BindView(R.id.result_rula_healthCare)
    ImageView menuHealthCare;
    @BindView(R.id.result_rula_home)
    ImageView menuHome;

    ActionBar actionBar;

    private int neckScore;
    private int trunkScore;
    private int upperArmScore;
    private int legsScore;
    private int lowerArmScore;
    private int wristScore;
    private int wristTwistScore;
    private int armAndWristMuscleScore;
    private int armAndWristLoadScore;
    private int neckTrunkLegsMuscleScore;
    private int neckTrunkLegsLoadScore;

    private int postureScoreA;
    private int postureScoreB;
    private int wristArmScore;
    private int neckTrunkLegsScore;
    private int finalScore;

    private Map<MapKeyRulaA, Integer> mapTableA;
    private Map<MapKeyRulaB, Integer> mapTableB;

    private MapKeyRulaA mapKeyRulaA;
    private MapKeyRulaB mapKeyRulaB;

    private Bitmap bmpResult;
    private String pathToResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_rula);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Result RULA");
        }

        // init table
        initTableA();
        initTableB();

        // Get intent
        Intent intent = getIntent();
        neckScore = intent.getIntExtra("neckScore", 0);
        trunkScore = intent.getIntExtra("trunkScore", 0);
        upperArmScore = intent.getIntExtra("upperArmScore", 0);
        legsScore = intent.getIntExtra("legsScore", 0);
        lowerArmScore = intent.getIntExtra("lowerArmScore", 0);
        wristScore = intent.getIntExtra("wristScore", 0);
        wristTwistScore = intent.getIntExtra("wristTwistScore", 0);
        armAndWristMuscleScore = intent.getIntExtra("armAndWristMuscleScore", 0);
        armAndWristLoadScore = intent.getIntExtra("armAndWristLoadScore", 0);
        neckTrunkLegsMuscleScore = intent.getIntExtra("neckTrunkLegsMuscleScore", 0);
        neckTrunkLegsLoadScore = intent.getIntExtra("neckTrunkLegsLoadScore", 0);
        pathToResult = intent.getStringExtra("bmpResult");

        // calculate result
        mapKeyRulaA = new MapKeyRulaA(upperArmScore, lowerArmScore, wristScore, wristTwistScore);
        mapKeyRulaB = new MapKeyRulaB(neckScore, trunkScore, legsScore);

        if (mapTableA.containsKey(mapKeyRulaA)) {
            postureScoreA = mapTableA.get(mapKeyRulaA);
        } else {
            postureScoreA = 0;
        }

        if (mapTableB.containsKey(mapKeyRulaB)) {
            postureScoreB = mapTableB.get(mapKeyRulaB);
        } else {
            postureScoreB = 0;
        }

        wristArmScore = postureScoreA + armAndWristMuscleScore + armAndWristLoadScore;
        neckTrunkLegsScore = postureScoreB + neckTrunkLegsMuscleScore + neckTrunkLegsLoadScore;

        calculateFinalScore();

        String stringHighScoreName = calculateMaxScore();

        // set image result
        loadImageFromStorage(pathToResult);

        // set text
        tvNeckScore.setText("Neck Score: " + String.valueOf(neckScore));
        tvTrunkScore.setText("Trunk Score: " + String.valueOf(trunkScore));
        tvUpperArmScore.setText("Upper Arm Score: " + String.valueOf(upperArmScore));
        tvLowerArmScore.setText("Lower Arm Score: " + String.valueOf(lowerArmScore));
        String totalWrist = String.valueOf((wristScore + wristTwistScore));
        tvWristScore.setText("Wrist Score: " + totalWrist);
        tvTotalScore.setText("Total Score: " + finalScore);
        tvPartHighScore.setText(stringHighScoreName);

        // set on click menu
        menuSideView.setOnClickListener(view -> sideView());
        menuSave.setOnClickListener(view -> saveScreen());
        menuHealthCare.setOnClickListener(view -> healthCare());
        menuHome.setOnClickListener(view -> home());
    }

    private void sideView() {

    }

    private void saveScreen() {

    }

    private void healthCare() {
    }

    private void home() {
        Intent intent = new Intent(ResultRulaActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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
        int totalWrist = wristScore + wristTwistScore;
        if (totalWrist > maxScore) {
            maxScore = totalWrist;
            maxName = "Wrist";
        }

        return maxName;

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

    private void initTableA() {
        RulaTableA rulaTableA = new RulaTableA();
        mapTableA = rulaTableA.getMapTableA();
    }

    private void initTableB() {
        RulaTableB rulaTableB = new RulaTableB();
        mapTableB = rulaTableB.getMapTableB();
    }

    private void calculateFinalScore() {
        if (wristArmScore == 1) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 1;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 2;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 5;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 5;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 2) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 2;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 2;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 5;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 5;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 3) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 5;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 6;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 4) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 3;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 6;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 6;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 5) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 7;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 7;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 6) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 4;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 7;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 7;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore == 7) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 7;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 7;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 7;
            } else {
                finalScore = 0;
            }
        } else if (wristArmScore >= 8) {
            if (neckTrunkLegsScore == 1) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 2) {
                finalScore = 5;
            } else if (neckTrunkLegsScore == 3) {
                finalScore = 6;
            } else if (neckTrunkLegsScore == 4) {
                finalScore = 7;
            } else if (neckTrunkLegsScore == 5) {
                finalScore = 7;
            } else if (neckTrunkLegsScore == 6) {
                finalScore = 7;
            } else if (neckTrunkLegsScore >= 7) {
                finalScore = 7;
            } else {
                finalScore = 0;
            }
        } else {
            finalScore = 0;
        }
    }
}
