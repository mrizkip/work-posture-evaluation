package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.util.CameraGallerySelectorDialog;
import com.example.mrizk.workpostureevaluationrula_reba.util.DrawView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RebaNeckTrunkActivity extends AppCompatActivity {

    private static final String TAG = "RebaNeckTrunkActivity";

    @BindView(R.id.reba_neck_trunk_imageView)
    ImageView imageView;
    @BindView(R.id.reba_neck_trunk_neckCheck1)
    CheckBox neck1;
    @BindView(R.id.reba_neck_trunk_neckCheck2)
    CheckBox neck2;
    @BindView(R.id.reba_neck_trunk_trunkCheck1)
    CheckBox trunk1;
    @BindView(R.id.reba_neck_trunk_trunkCheck2)
    CheckBox trunk2;
    @BindView(R.id.reba_neck_trunk_upperArm_check1)
    CheckBox upperArm1;
    @BindView(R.id.reba_neck_trunk_upperArm_check2)
    CheckBox upperArm2;
    @BindView(R.id.reba_neck_trunk_upperArm_check3)
    CheckBox upperArm3;

    @BindView(R.id.reba_neck_trunk_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;

    private CameraGallerySelectorDialog selectorDialog;

    private int neckValue = 0;
    private int neckPosition;
    private int trunkValue = 0;
    private int trunkPosition;
    private int upperArmValue = 0;
    private int upperArmPosition;
    private int lowerArmValue = 0;
    private int lowerArmPosition;
    private int wristPosition;
    private int legsValue;
    private int legsPosition;

    private double trunkDegree;
    private double neckDegree;
    private double upperArmDegree;
    private double lowerArmDegree;
    private double wristDegree;
    private double legsDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_neck_trunk);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("REBA NECK TRUNK UPPER ARM");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // get intent
        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);

        // get degrees
        trunkDegree = intent.getDoubleExtra("trunkPosition", 0);
        neckDegree = intent.getDoubleExtra("neckPosition", 0);
        upperArmDegree = intent.getDoubleExtra("upperArmPosition", 0);
        lowerArmDegree = intent.getDoubleExtra("lowerArmPosition", 0);
        wristDegree = intent.getDoubleExtra("wristPosition", 0);
        legsDegree = intent.getDoubleExtra("legsPosition", 0);
        legsValue = intent.getIntExtra("legsValue", 0);

        // calculate score of position
        calculatePositionScore(trunkDegree, neckDegree, upperArmDegree, lowerArmDegree, wristDegree, legsDegree);

        // check result
        Log.d(TAG, "onCreate: trunk score " + trunkPosition);
        Log.d(TAG, "onCreate: neck score " + neckPosition);
        Log.d(TAG, "onCreate: upperArm score " + upperArmPosition);
        Log.d(TAG, "onCreate: lowerArm score " + lowerArmPosition);
        Log.d(TAG, "onCreate: wrist score " + wristPosition);
        Log.d(TAG, "onCreate: legs score " + legsPosition);

        // create camera and gallery selector dialog
        selectorDialog = new CameraGallerySelectorDialog(this);

        selectorDialog.setOnSelectionSelected(new CameraGallerySelectorDialog.OnSelectionSelected() {
            @Override
            public void onCameraButtonClicked() {
                EZPhotoPickConfig cameraConfig = new EZPhotoPickConfig();
                cameraConfig.photoSource = PhotoSource.CAMERA;
                cameraConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RebaNeckTrunkActivity.this, cameraConfig);
            }

            @Override
            public void onGalleryButtonClicked() {
                EZPhotoPickConfig galleryConfig = new EZPhotoPickConfig();
                galleryConfig.photoSource = PhotoSource.GALLERY;
                galleryConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RebaNeckTrunkActivity.this, galleryConfig);
            }
        });

        // Check Neck CheckBox
        neckValue = neckValue + neckPosition;
        neck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckValue = neckValue + 1;
                } else {
                    neckValue = neckValue - 1;
                }
            }
        });

        neck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    neckValue = neckValue + 1;
                } else {
                    neckValue = neckValue - 1;
                }
            }
        });

        // Check Trunk CheckBox
        trunkValue = trunkValue + trunkPosition;
        trunk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    trunkValue = trunkValue + 1;
                } else {
                    trunkValue = trunkValue - 1;
                }
            }
        });

        trunk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    trunkValue = trunkValue + 1;
                } else {
                    trunkValue = trunkValue - 1;
                }
            }
        });

        // Check UpperArm CheckBox
        upperArmValue = upperArmValue + upperArmPosition;
        upperArm1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue + 1;
                } else {
                    upperArmValue = upperArmValue - 1;
                }
            }
        });

        upperArm2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue + 1;
                } else {
                    upperArmValue = upperArmValue - 1;
                }
            }
        });

        upperArm3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    upperArmValue = upperArmValue - 1;
                } else {
                    upperArmValue = upperArmValue + 1;
                }
            }
        });

        // Check LowerArm Position
        lowerArmValue = lowerArmValue + lowerArmPosition;

        // legs position
        legsValue = legsValue + legsPosition;

    }

    private void calculatePositionScore(double trunkDegree, double neckDegree, double upperArmDegree,
                                        double lowerArmDegree, double wristDegree, double legsDegree) {
        long trunk = Math.round(trunkDegree);
        long neck = Math.round(neckDegree);
        long upperArm = Math.round(upperArmDegree);
        long lowerArm = Math.round(lowerArmDegree);
        long wrist = Math.round(wristDegree);
        long legs = Math.round(legsDegree);

        // trunk
        if (trunk == 0) {
            trunkPosition = 1;
        } else if (trunk > 0 && trunk <= 20) {
            trunkPosition = 2;
        } else if (trunk > 20 && trunk <= 60) {
            trunkPosition = 3;
        } else if (trunk > 60) {
            trunkPosition = 4;
        } else if (trunk < 0) {
            trunkPosition = 2;
        }

        // neck
        if (neck >= 0 && neck <= 20) {
            neckPosition = 1;
        } else if (neck > 20) {
            neckPosition = 2;
        } else if (neck < 0) {
            neckPosition = 2;
        }

        // upper arm TODO: Calculate if in extension > 20
        if (upperArm >= 0 && upperArm <= 20) {
            upperArmPosition = 1;
        } else if ((upperArm > 20 && upperArm <= 45) || (upperArm < 0 && upperArm >= -20)) {
            upperArmPosition = 2;
        } else if (upperArm > 45 && upperArm <= 90) {
            upperArmPosition = 3;
        } else if (upperArm > 90) {
            upperArmPosition = 4;
        }

        // lower arm
        if (lowerArm >= 60 && lowerArm <= 100) {
            lowerArmPosition = 1;
        } else if ((lowerArm > 100) || (lowerArm < 60)) {
            lowerArmPosition = 2;
        }

        // wrist
        if (wrist >= 0 && wrist <= 15) {
            wristPosition = 1;
        } else if (wrist > 15) {
            wristPosition = 2;
        }

        // legs
        if (legs >= 30 && legs <= 60) {
            legsPosition = 1;
        } else if (legs > 60) {
            legsPosition = 2;
        } else if (legs < 30) {
            legsPosition = 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_neck_trunk, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_neck_trunk_next);
        Drawable drawable = itemNext.getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.reba_neck_trunk_next:
                selectorDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == EZPhotoPick.PHOTO_PICK_GALLERY_REQUEST_CODE
                    || requestCode == EZPhotoPick.PHOTO_PICK_CAMERA_REQUEST_CODE) {
                try {
                    Bitmap pickedPhoto = new EZPhotoPickStorage(this).loadLatestStoredPhotoBitmap();
                    Intent intent = new Intent(RebaNeckTrunkActivity.this, RebaWristActivity.class);
                    intent.putExtra("photo", pickedPhoto);
                    intent.putExtra("trunkScore", trunkValue);
                    intent.putExtra("neckScore", neckValue);
                    intent.putExtra("upperArmScore", upperArmValue);
                    intent.putExtra("lowerArmScore", lowerArmValue);
                    intent.putExtra("wristPosition", wristPosition);
                    intent.putExtra("legsScore", legsValue);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
