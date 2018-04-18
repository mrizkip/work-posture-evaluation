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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.rula.RulaSudutActivity;
import com.example.mrizk.workpostureevaluationrula_reba.rula.RulaUpperArmNeckTrunkActivity;
import com.example.mrizk.workpostureevaluationrula_reba.util.CameraGallerySelectorDialog;
import com.example.mrizk.workpostureevaluationrula_reba.util.DrawView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RebaSudutActivity extends AppCompatActivity {

    private static final String TAG = "RebaSudutActivity";

    @BindView(R.id.reba_sudut_toolbar)
    Toolbar toolbar;
    @BindView(R.id.reba_sudut_drawView)
    DrawView imageView;
    @BindView(R.id.reba_sudut_leg_radioGroup)
    RadioGroup legsGroup;
    @BindView(R.id.reba_sudut_cbTrunk)
    CheckBox cbTrunk;
    @BindView(R.id.reba_sudut_cbNeck)
    CheckBox cbNeck;
    @BindView(R.id.reba_sudut_cbUpperArm)
    CheckBox cbUpperArm;

    ActionBar actionBar;

    private CameraGallerySelectorDialog selectorDialog;

    private int legsValue = 0;
    private int legsRadio;

    private List<DrawView.Line> lineList;
    private List<Double> degreeList;
    private Double trunkDegree;
    private Double neckDegree;
    private Double upperArmDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reba_sudut);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("REBA SUDUT");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);
        imageView.setType("REBA");

        lineList = new ArrayList<>();
        degreeList = new ArrayList<>();

        selectorDialog = new CameraGallerySelectorDialog(this);

        selectorDialog.setOnSelectionSelected(new CameraGallerySelectorDialog.OnSelectionSelected() {
            @Override
            public void onCameraButtonClicked() {
                EZPhotoPickConfig cameraConfig = new EZPhotoPickConfig();
                cameraConfig.photoSource = PhotoSource.CAMERA;
                cameraConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RebaSudutActivity.this, cameraConfig);
            }

            @Override
            public void onGalleryButtonClicked() {
                EZPhotoPickConfig galleryConfig = new EZPhotoPickConfig();
                galleryConfig.photoSource = PhotoSource.GALLERY;
                galleryConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RebaSudutActivity.this, galleryConfig);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reba_sudut, menu);

        MenuItem itemNext = menu.findItem(R.id.reba_sudut_next);
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
            case R.id.reba_sudut_next:
                lineList = imageView.getLineList();
                if (lineList.size() < 6) {
                    Toast.makeText(this, "Sudut yang dibuat harus sebanyak 6!", Toast.LENGTH_SHORT).show();
                } else {
                    calculateDegree(lineList);
                    // mengecek check box
                    trunkDegree = degreeList.get(0);
                    if (cbTrunk.isChecked()) {
                        trunkDegree *= -1;
                    }
                    neckDegree = degreeList.get(1);
                    if (cbNeck.isChecked()) {
                        neckDegree *= -1;
                    }
                    upperArmDegree = degreeList.get(2);
                    if (cbUpperArm.isChecked()) {
                        upperArmDegree *= -1;
                    }

                    // mengambil radio button
                    int radioButtonId = legsGroup.getCheckedRadioButtonId();
                    switch (radioButtonId) {
                        case R.id.reba_sudut_leg_radio1:
                            legsRadio = 1;
                            break;
                        case R.id.reba_sudut_leg_radio2:
                            legsRadio = 2;
                            break;
                    }
                    legsValue = legsValue + legsRadio;

                    selectorDialog.show();
                }
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
                    Intent intent = new Intent(RebaSudutActivity.this, RebaNeckTrunkActivity.class);
                    intent.putExtra("photo", pickedPhoto);
                    intent.putExtra("trunkPosition", trunkDegree);
                    intent.putExtra("neckPosition", neckDegree);
                    intent.putExtra("upperArmPosition", upperArmDegree);
                    intent.putExtra("lowerArmPosition", degreeList.get(3));
                    intent.putExtra("wristPosition", degreeList.get(4));
                    intent.putExtra("legsPosition", degreeList.get(5));
                    intent.putExtra("legsValue", legsValue);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void calculateDegree(List<DrawView.Line> lineList) {
        if (lineList.size() >= 2) {
            for (int i = 0; i < lineList.size(); i++) {
                if (!(i % 2 == 0)) {
                    double degree = Math.toDegrees(imageView.calculateAngle(lineList.get(i - 1), lineList.get(i)));
                    degree = Math.abs(degree);
                    if (degree > 180) {
                        degree = 360 - degree;
                    }
                    Log.d(TAG, "calculateDegree: " + degree);
                    degreeList.add(degree);
                }
            }
        }
    }
}
