package com.example.mrizk.workpostureevaluationrula_reba.rula;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.example.mrizk.workpostureevaluationrula_reba.util.CameraGallerySelectorDialog;
import com.example.mrizk.workpostureevaluationrula_reba.util.DrawView;
import com.example.mrizk.workpostureevaluationrula_reba.util.HelpDialog;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class RulaSudutActivity extends AppCompatActivity {

    private static final String TAG = "RulaSudutActivity";

    @BindView(R.id.rula_sudut_toolbar)
    Toolbar toolbar;
    @BindView(R.id.rula_sudut_drawView)
    DrawView imageView;
    @BindView(R.id.rula_sudut_leg_radioGroup)
    RadioGroup legsGroup;
    @BindView(R.id.rula_sudut_cbUpperArm)
    CheckBox cbUpperArm;
    @BindView(R.id.rula_sudut_cbNeck)
    CheckBox cbNeck;
    @BindView(R.id.rula_sudut_ivNeck1)
    ImageView ivNeck1;
    @BindView(R.id.rula_sudut_ivUpperArm)
            ImageView ivUpperArm1;
    @BindView(R.id.rula_sudut_leg_ivLegs)
            ImageView ivLegs;

    ActionBar actionBar;

    private CameraGallerySelectorDialog selectorDialog;
    private HelpDialog helpDialog;

    private int legsRadio;
    private int legsValue = 0;

    private List<DrawView.Line> lineList;
    private List<Double> degreeList;
    private Double upperArmDegree;
    private Double neckDegree;

//    private Bitmap bmpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_sudut);

        ButterKnife.bind(this);

        if (toolbar != null) setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle("Side View");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
        imageView.setImageBitmap(bitmap);
        imageView.setType("RULA");

        lineList = new ArrayList<>();
        degreeList = new ArrayList<>();

        // Create Selector Dialog
        selectorDialog = new CameraGallerySelectorDialog(this);
        selectorDialog.setChooseString("Take Front Posture");

        selectorDialog.setOnSelectionSelected(new CameraGallerySelectorDialog.OnSelectionSelected() {
            @Override
            public void onCameraButtonClicked() {
                EZPhotoPickConfig cameraConfig = new EZPhotoPickConfig();
                cameraConfig.photoSource = PhotoSource.CAMERA;
                cameraConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaSudutActivity.this, cameraConfig);
            }

            @Override
            public void onGalleryButtonClicked() {
                EZPhotoPickConfig galleryConfig = new EZPhotoPickConfig();
                galleryConfig.photoSource = PhotoSource.GALLERY;
                galleryConfig.exportingSize = 400;
                EZPhotoPick.startPhotoPickActivity(RulaSudutActivity.this, galleryConfig);
            }
        });

        // Create Help Dialog
        helpDialog = new HelpDialog(this);

        // add drawable right
        addDrawableRight();

    }

    private void addDrawableRight() {
        // neck
        Picasso.get().load("file:///android_asset/neck_extention.png").into(ivNeck1);

        // upper arm
        Picasso.get().load("file:///android_asset/upper_arm_extention.png").into(ivUpperArm1);

        // legs
        Picasso.get().load("file:///android_asset/legs.png").into(ivLegs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rula_sudut, menu);

        MenuItem itemNext = menu.findItem(R.id.sudut_next);
        Drawable drawable = itemNext.getIcon();
        drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        MenuItem itemHelp = menu.findItem(R.id.sudut_help);
        Drawable helpIcon = itemHelp.getIcon();
        helpIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.sudut_next:
                // save image
//                imageView.setDrawingCacheEnabled(true);
//                bmpResult = Bitmap.createBitmap(imageView.getDrawingCache());
//                imageView.setDrawingCacheEnabled(false);
//                bmpResult = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

                // hitung sudut
                lineList = imageView.getLineList();
                if (lineList.size() < 5) {
                    Toast.makeText(this, "Sudut yang dibuat harus sebanyak 5!", Toast.LENGTH_SHORT).show();
                } else {
                    calculateDegree(lineList);
                    // Mengecek check box
                    upperArmDegree = degreeList.get(2);
                    if (cbUpperArm.isChecked()) {
                        upperArmDegree *= -1;
                    }
                    neckDegree = degreeList.get(1);
                    if (cbNeck.isChecked()) {
                        neckDegree *= -1;
                    }

                    // Mengambil jawaban radio button legs
                    int radioButtonId = legsGroup.getCheckedRadioButtonId();
                    switch (radioButtonId) {
                        case R.id.rula_sudut_leg_radio1:
                            legsRadio = 1;
                            break;
                        case R.id.rula_sudut_leg_radio2:
                            legsRadio = 2;
                            break;
                    }

                    legsValue = legsValue + legsRadio;
                    selectorDialog.show();
                }
                return true;
            case R.id.sudut_help:
                helpDialog.show();
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
                    Intent intent = new Intent(RulaSudutActivity.this, RulaUpperArmNeckTrunkActivity.class);
                    intent.putExtra("photo", pickedPhoto);
                    intent.putExtra("trunkPosition", degreeList.get(0));
                    intent.putExtra("neckPosition", neckDegree);
                    intent.putExtra("upperArmPosition", upperArmDegree);
                    intent.putExtra("lowerArmPosition", degreeList.get(3));
                    intent.putExtra("wristPosition", degreeList.get(4));
                    intent.putExtra("legsScore", legsValue);
//                    intent.putExtra("bmpResult", bmpResult);
                    startActivity(intent);
                } catch (IOException e) {
                    Log.e(TAG, "onActivityResult: Error here");
                    e.printStackTrace();
                }
            }
        }
    }

    private void calculateDegree(List<DrawView.Line> lineList) {
        Log.d(TAG, "calculateDegree: " + lineList.size());
        if (lineList.size() >= 2) {
            for (int i = 0; i < lineList.size(); i++) {
                if (!(i % 2 == 0)) {
                    double degree = Math.toDegrees(imageView.calculateAngle(lineList.get(i - 1), lineList.get(i)));
                    degree = Math.abs(degree);
                    if (degree > 180) {
                        degree = 360 - degree;
                    }
                    degreeList.add(degree);
                }
            }
        }
    }

}
