package com.example.mrizk.workpostureevaluationrula_reba.rula;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mrizk.workpostureevaluationrula_reba.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RulaActivity extends AppCompatActivity {

//    public static final int PHOTO_PICK_CAMERA_REQUEST_CODE = 9067;
//    public static final int PHOTO_PICK_GALLERY_REQUEST_CODE = 9068;

    @BindView(R.id.rula_toolbar)
    Toolbar toolbar;
    @BindView(R.id.rula_imageView)
    ImageView imageViewRula;
    @BindView(R.id.rula_cameraContainer)
    RelativeLayout cameraContainer;
    @BindView(R.id.rula_galleryContainer)
    RelativeLayout galleryContainer;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("RULA");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cameraContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EZPhotoPickConfig cameraConfig = new EZPhotoPickConfig();
                cameraConfig.photoSource = PhotoSource.CAMERA;
                cameraConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaActivity.this, cameraConfig);
            }
        });
        galleryContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EZPhotoPickConfig galleryConfig = new EZPhotoPickConfig();
                galleryConfig.photoSource = PhotoSource.GALLERY;
                galleryConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaActivity.this, galleryConfig);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == EZPhotoPick.PHOTO_PICK_GALLERY_REQUEST_CODE
                    || requestCode == EZPhotoPick.PHOTO_PICK_CAMERA_REQUEST_CODE) {
                try {
                    Bitmap pickedPhoto = new EZPhotoPickStorage(this).loadLatestStoredPhotoBitmap();
                    Intent intent = new Intent(RulaActivity.this, RulaSudutActivity.class);
                    intent.putExtra("photo", pickedPhoto);
                    startActivity(intent);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


