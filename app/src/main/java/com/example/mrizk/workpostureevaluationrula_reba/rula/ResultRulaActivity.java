package com.example.mrizk.workpostureevaluationrula_reba.rula;

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
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRulaA;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRulaB;
import com.example.mrizk.workpostureevaluationrula_reba.util.MapKeyRulaC;
import com.example.mrizk.workpostureevaluationrula_reba.util.RulaTableA;
import com.example.mrizk.workpostureevaluationrula_reba.util.RulaTableB;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultRulaActivity extends AppCompatActivity {

    private static final String TAG = "ResultRulaActivity";

    @BindView(R.id.result_rula_toolbar)
    Toolbar toolbar;
    @BindView(R.id.result_rula_buttonStart)
    Button buttonStart;
    @BindView(R.id.result_rula_scoreA)
    TextView textScoreA;
    @BindView(R.id.result_rula_scoreB)
            TextView textScoreB;
    @BindView(R.id.result_rula_scoreFinal)
            TextView textScoreFinal;
    @BindView(R.id.result_rula_scoreAMuscle)
            TextView textMuscleA;
    @BindView(R.id.result_rula_scoreALoad)
            TextView textLoadA;
    @BindView(R.id.result_rula_scoreBMuscle)
            TextView textMuscleB;
    @BindView(R.id.result_rula_scoreBLoad)
            TextView textLoadB;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_rula);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RESULT RULA");
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

        Log.d(TAG, "onCreate: neckScore: " + neckScore);
        Log.d(TAG, "onCreate: trunkScore: " + trunkScore);
        Log.d(TAG, "onCreate: upperArmScore: " + upperArmScore);
        Log.d(TAG, "onCreate: legsScore: " + legsScore);
        Log.d(TAG, "onCreate: lowerArmScore: " + lowerArmScore);
        Log.d(TAG, "onCreate: wristScore: " + wristScore);
        Log.d(TAG, "onCreate: wristTwistScore: " + wristTwistScore);
        Log.d(TAG, "onCreate: armAndWristMuscleScore: " + armAndWristMuscleScore);
        Log.d(TAG, "onCreate: armAndWristLoadScore: " + armAndWristLoadScore);
        Log.d(TAG, "onCreate: neckTrunkLegsMuscleScore: " + neckTrunkLegsMuscleScore);
        Log.d(TAG, "onCreate: neckTrunkLegsLoadScore: " + neckTrunkLegsLoadScore);


        // calculate result
        mapKeyRulaA = new MapKeyRulaA(upperArmScore, lowerArmScore, wristScore, wristTwistScore);
        mapKeyRulaB = new MapKeyRulaB(neckScore, trunkScore, legsScore);

        if (mapTableA.containsKey(mapKeyRulaA)) {
            postureScoreA = mapTableA.get(mapKeyRulaA);
        } else {
            postureScoreA = 0;
        }
        Log.d(TAG, "onCreate: Score Posture A: " + String.valueOf(postureScoreA));

        if (mapTableB.containsKey(mapKeyRulaB)) {
            postureScoreB = mapTableB.get(mapKeyRulaB);
        } else {
            postureScoreB = 0;
        }
        Log.d(TAG, "onCreate: Score Posture B: " + String.valueOf(postureScoreB));

        wristArmScore = postureScoreA + armAndWristMuscleScore + armAndWristLoadScore;
        neckTrunkLegsScore = postureScoreB + neckTrunkLegsMuscleScore + neckTrunkLegsLoadScore;

        calculateFinalScore();
        Log.d(TAG, "onCreate: finalScore: " + String.valueOf(finalScore));

        // set text
        textScoreA.setText("Posture Score A: " + String.valueOf(postureScoreA));
        textMuscleA.setText("Arm/Wrist Muscle Use Score: " + String.valueOf(armAndWristMuscleScore));
        textLoadA.setText("Arm/Wrist Force / Load Score: " + String.valueOf(armAndWristLoadScore));
        textScoreB.setText("Posture Score B: " + String.valueOf(postureScoreB));
        textMuscleB.setText("Neck Trunk Legs Muscle Use Score: " + String.valueOf(neckTrunkLegsMuscleScore));
        textLoadB.setText("Neck Trunk Legs Force / Load Score: " + String.valueOf(neckTrunkLegsLoadScore));
        textScoreFinal.setText("Final Score: " + String.valueOf(finalScore));

        // Home
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultRulaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
