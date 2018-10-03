package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.squareup.picasso.Picasso;

public class CameraGallerySelectorDialog {

    private final AlertDialog.Builder alertDialogBuilder;
    private final Context context;

    private OnSelectionSelected onSelectionSelected;

    private Drawable cameraIcon;
    private Drawable galleryIcon;
    private String chooseString;
    private String cancelString;
    private String cameraString;
    private String galleryString;
    private Drawable imageIntro;
    private String imageString;

    private AlertDialog builtDialog;

    public CameraGallerySelectorDialog(Context context) {
        alertDialogBuilder = new AlertDialog.Builder(context);
        this.context = context;

        setupDefaultConfig();
    }

    private void setupDefaultConfig() {
        cameraString = "Camera";
        galleryString = "Gallery";
        chooseString = "Choose";
        cancelString = "Cancel";
        cameraIcon = ContextCompat.getDrawable(context, R.drawable.ic_camera_alt_black_24dp);
        galleryIcon = ContextCompat.getDrawable(context, R.drawable.ic_image_black_24dp);
        imageIntro = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
    }

    public void show() {
        alertDialogBuilder.setView(provideDialogView());
        alertDialogBuilder.setTitle(chooseString);
        alertDialogBuilder.setNegativeButton(cancelString, null);
        builtDialog = alertDialogBuilder.create();
        builtDialog.show();
    }

    private View provideDialogView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_camera_gallery_selector, null);
        RelativeLayout cameraContainer = (RelativeLayout) view.findViewById(R.id.cameraGallerySelector_cameraContainer);
        RelativeLayout galleryContainer = (RelativeLayout) view.findViewById(R.id.cameraGallerySelector_galleryContainer);
        ImageView cameraIconField = (ImageView) view.findViewById(R.id.cameraGallerySelector_cameraIcon);
        ImageView galleryIconField = (ImageView) view.findViewById(R.id.cameraGallerySelector_galleryIcon);
        TextView cameraTextField = (TextView) view.findViewById(R.id.cameraGallerySelector_cameraString);
        TextView galleryTextField = (TextView) view.findViewById(R.id.cameraGallerySelector_galleryString);
        ImageView imageIntroField = (ImageView) view.findViewById(R.id.cameraGallerySelector_imageIntro);

        imageIntroField.setImageDrawable(imageIntro);
        cameraIconField.setImageDrawable(cameraIcon);
        galleryIconField.setImageDrawable(galleryIcon);
        cameraTextField.setText(cameraString);
        galleryTextField.setText(galleryString);

        try {
            Picasso.get().load(imageString).error(R.mipmap.ic_launcher).into(imageIntroField);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cameraContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builtDialog.dismiss();
                if (onSelectionSelected != null) {
                    onSelectionSelected.onCameraButtonClicked();
                }
            }
        });
        galleryContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builtDialog.dismiss();
                if (onSelectionSelected != null) {
                    onSelectionSelected.onGalleryButtonClicked();
                }
            }
        });

        return view;
    }

    public void setCameraIcon(Drawable cameraIcon) {
        this.cameraIcon = cameraIcon;
    }

    public void setGalleryIcon(Drawable galleryIcon) {
        this.galleryIcon = galleryIcon;
    }

    public void setCameraIconRes(@DrawableRes int cameraIconRes) {
        this.cameraIcon = ContextCompat.getDrawable(context, cameraIconRes);
    }

    public void setGalleryIconRes(@DrawableRes int galleryIconRes) {
        this.galleryIcon = ContextCompat.getDrawable(context, galleryIconRes);
    }

    public void setCameraString(String cameraString) {
        this.cameraString = cameraString;
    }

    public void setGalleryString(String galleryString) {
        this.galleryString = galleryString;
    }

    public void setChooseString(String chooseString) {
        this.chooseString = chooseString;
    }

    public void setCancelString(String cancelString) {
        this.cancelString = cancelString;
    }

    public void setCameraStringRes(@StringRes int cameraStringRes) {
        this.cameraString = context.getResources().getString(cameraStringRes);
    }

    public void setGalleryStringRes(@StringRes int galleryStringRes) {
        this.galleryString = context.getResources().getString(galleryStringRes);
    }

    public void setChooseStringRes(@StringRes int chooseStringRes) {
        this.chooseString = context.getResources().getString(chooseStringRes);
    }

    public void setCancelStringRes(@StringRes int cancelStringRes) {
        this.cancelString = context.getResources().getString(cancelStringRes);
    }

    public Drawable getImageIntro() {
        return imageIntro;
    }

    public void setImageIntro(Drawable imageIntro) {
        this.imageIntro = imageIntro;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public void setOnSelectionSelected(OnSelectionSelected listener) {
        this.onSelectionSelected = listener;
    }

    public interface OnSelectionSelected {
        void onCameraButtonClicked();

        void onGalleryButtonClicked();
    }

}
