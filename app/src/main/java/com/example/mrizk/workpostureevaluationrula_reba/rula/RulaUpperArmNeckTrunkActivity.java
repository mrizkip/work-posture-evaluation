package com.example.mrizk.workpostureevaluationrula_reba.rula;

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

public class RulaUpperArmNeckTrunkActivity extends AppCompatActivity {

    private static final String TAG = "RulaUpperArmNeckTrunkAc";

    @BindView(R.id.rula_upperArm_imageView)
    ImageView imageView;
    @BindView(R.id.rula_upperArm_check1)
    CheckBox upperArm1;
    @BindView(R.id.rula_upperArm_check2)
    CheckBox upperArm2;
    @BindView(R.id.rula_upperArm_check3)
    CheckBox upperArm3;
    @BindView(R.id.rula_neck_Neck_check1)
    CheckBox neck1;
    @BindView(R.id.rula_neck_Neck_check2)
    CheckBox neck2;
    @BindView(R.id.rula_trunk_check1)
    CheckBox trunk1;
    @BindView(R.id.rula_trunk_check2)
    CheckBox trunk2;

    @BindView(R.id.rula_upperArm_toolbar)
    Toolbar toolbar;

    ActionBar actionBar;

    private int upperArmValue = 0;
    private int upperArmPosition;
    private int neckValue = 0;
    private int neckPosition;
    private int trunkValue = 0;
    private int trunkPosition;
    private int lowerArmPosition;
    private int wristPosition;

    private double trunkDegree;
    private double neckDegree;
    private double upperArmDegree;
    private double lowerArmDegree;
    private double wristDegree;

    private int legsScore;

    private CameraGallerySelectorDialog selectorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_upper_arm_neck_trunk);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA Upeer Arm Neck Trunk");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get Intent and Place Image
        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);

        // get degrees
        trunkDegree = intent.getDoubleExtra("trunkPosition", 0);
        neckDegree = intent.getDoubleExtra("neckPosition", 0);
        upperArmDegree = intent.getDoubleExtra("upperArmPosition", 0);
        lowerArmDegree = intent.getDoubleExtra("lowerArmPosition", 0);
        wristDegree = intent.getDoubleExtra("wristPosition", 0);
        legsScore = intent.getIntExtra("legsScore", 0);

        // calculate score of position
        calculatePositionScore(trunkDegree, neckDegree, upperArmDegree, lowerArmDegree, wristDegree);

        // Create Camera and Gallery Selector Dialog
        selectorDialog = new CameraGallerySelectorDialog(this);
        selectorDialog.setChooseString("Take Top Posture");

        selectorDialog.setOnSelectionSelected(new CameraGallerySelectorDialog.OnSelectionSelected() {
            @Override
            public void onCameraButtonClicked() {
                EZPhotoPickConfig cameraConfig = new EZPhotoPickConfig();
                cameraConfig.photoSource = PhotoSource.CAMERA;
                cameraConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaUpperArmNeckTrunkActivity.this, cameraConfig);
            }

            @Override
            public void onGalleryButtonClicked() {
                EZPhotoPickConfig galleryConfig = new EZPhotoPickConfig();
                galleryConfig.photoSource = PhotoSource.GALLERY;
                galleryConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaUpperArmNeckTrunkActivity.this, galleryConfig);
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

    }

    private void calculatePositionScore(double trunkDegree, double neckDegree, double upperArmDegree,
                                        double lowerArmDegree, double wristDegree) {
        long trunk = Math.round(trunkDegree);
        long neck = Math.round(neckDegree);
        long upperArm = Math.round(upperArmDegree);
        long lowerArm = Math.round(lowerArmDegree);
        long wrist = Math.round(wristDegree);

        // trunk
        if (trunk == 0) {
            trunkPosition = 1;
        } else if (trunk > 0 && trunk <= 20) {
            trunkPosition = 2;
        } else if (trunk > 20 && trunk <= 60) {
            trunkPosition = 3;
        } else if (trunk > 60) {
            trunkPosition = 4;
        }

        // neck
        if (neck >= 0 && neck <= 10) {
            neckPosition = 1;
        } else if (neck > 10 && neck <= 20) {
            neckPosition = 2;
        } else if (neck > 20) {
            neckPosition = 3;
        } else if (neck < 0) {
            neckPosition = 4;
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
        if (wrist == 0) {
            wristPosition = 1;
        } else if (wrist > 0 && wrist <= 15) {
            wristPosition = 2;
        } else if (wrist > 15) {
            wristPosition = 3;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_upper_arm_neck_trunk, menu);

        MenuItem itemNext = menu.findItem(R.id.rula_upper_arm_neck_trunk_next);
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
            case R.id.rula_upper_arm_neck_trunk_next:
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
                    Intent intent = new Intent(RulaUpperArmNeckTrunkActivity.this, RulaLowerArmActivity.class);
                    intent.putExtra("photo", pickedPhoto);
                    intent.putExtra("legsScore", legsScore);
                    intent.putExtra("upperArmScore", upperArmValue);
                    intent.putExtra("neckScore", neckValue);
                    intent.putExtra("trunkScore", trunkValue);
                    intent.putExtra("lowerArmPosition", lowerArmPosition);
                    intent.putExtra("wristPosition", wristPosition);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
