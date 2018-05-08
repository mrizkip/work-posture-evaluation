package com.example.mrizk.workpostureevaluationrula_reba.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mrizk.workpostureevaluationrula_reba.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends Fragment {

    @BindView(R.id.about_webContainer)
    RelativeLayout ivWebIcon;
    @BindView(R.id.about_mailContainer)
    RelativeLayout ivEmailIcon;
    @BindView(R.id.about_callContainer)
    RelativeLayout ivCallIcon;
    @BindView(R.id.about_imageAbout)
    ImageView imvAbout;

    public static AboutFragment newInstance() {
        AboutFragment aboutFragment = new AboutFragment();
        return aboutFragment;
    }


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ButterKnife.bind(this, view);

        Picasso.get().load("file:///android_asset/about.png").into(imvAbout);

        // set onClick
        ivWebIcon.setOnClickListener(v -> webClick());
        ivEmailIcon.setOnClickListener(v -> emailClick());
        ivCallIcon.setOnClickListener(v -> callClick());

        return view;
    }

    private void webClick() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lpke.ub.ac.id"));
        if (browserIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(browserIntent);
        } else {
            Toast.makeText(getContext(), "No browser app to open website!", Toast.LENGTH_SHORT).show();
        }
    }

    private void emailClick() {
        String address = "lpketiub@gmail.com";
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{address});
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        if (mailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mailIntent);
        } else {
            Toast.makeText(getContext(), "No emai app to send Email!\nPlease send mail to: " + address, Toast.LENGTH_LONG).show();
        }
    }

    private void callClick() {
        String phoneNumber = "+6285715057223";
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phoneNumber));
        if (callIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Toast.makeText(getContext(), "No dialer app to dial a number!", Toast.LENGTH_SHORT).show();
        }
    }

}
