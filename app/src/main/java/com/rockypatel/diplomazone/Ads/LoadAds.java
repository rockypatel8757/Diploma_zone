package com.rockypatel.diplomazone.Ads;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class LoadAds extends AppCompatActivity {
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
        InterstitialAds.interads(LoadAds.this);
    }
}
