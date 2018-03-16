package com.example.mrizk.workpostureevaluationrula_reba.reba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.util.CameraGallerySelectorDialog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RebaNeckTrunkActivity extends AppCompatActivity {

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

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_neck_trunk, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_neck_trunk_next);
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
                    startActivity(intent);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
