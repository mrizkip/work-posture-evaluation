package com.example.mrizk.workpostureevaluationrula_reba.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.mrizk.workpostureevaluationrula_reba.R;

public class HelpDialog {
    private final AlertDialog.Builder alertDialogBuilder;
    private final Context context;
    private AlertDialog builtDialog;

    private String title;
    private String okString;
    private Drawable imageHelp;


    public HelpDialog(Context context) {
        alertDialogBuilder = new AlertDialog.Builder(context);
        this.context = context;

        setupDefaultConfig();
    }

    private void setupDefaultConfig() {
        title = "Help";
        okString = "OK";
        imageHelp = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
    }

    private View provideDialogView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_help_sudut, null);
        ImageView imageView = view.findViewById(R.id.dialogHelp_imageView);

        imageView.setImageDrawable(imageHelp);
        return view;
    }

    public void show() {
        alertDialogBuilder.setView(provideDialogView());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton(okString, null);
        builtDialog = alertDialogBuilder.create();
        builtDialog.show();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImageHelp() {
        return imageHelp;
    }

    public void setImageHelp(Drawable imageHelp) {
        this.imageHelp = imageHelp;
    }
}
