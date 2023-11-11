package com.rockypatel.diplomazone;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.rockypatel.diplomazone.Ads.InterstitialAds;
import com.rockypatel.diplomazone.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        InterstitialAds.interads(this);

        setSupportActionBar(binding.tbm);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Polytechnic Courses");


        Intent intent=new Intent(this, ComputerScience.class);

        Intent intent3=new Intent(this, ComputerScience.class);
        Intent intent4=new Intent(this, Civil.class);
        Intent intent5=new Intent(this, ComputerScience.class);

        binding.imageButton1.setImageResource(R.drawable.computerscience);
        binding.imgbtn22.setImageResource(R.drawable.civil);
        binding.imgbtn33.setImageResource(R.drawable.mechanical);
        binding.imgbtn44.setImageResource(R.drawable.electronics);
        binding.imgbtn55.setImageResource(R.drawable.electricals);
        binding.nointernet.setImageResource(R.drawable.nointernet);
        if (isConnected()){
            binding.nointernet.setVisibility(View.GONE);
        }else {
            binding.nointernet.setVisibility(View.VISIBLE);
        }

        binding.imageButton1.setOnClickListener(v -> {
            intent.putExtra("title","Computer Science");
            startActivity(intent);
                });
        binding.imgbtn22.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Civil.class);
            intent2.putExtra("title","Civil");
            startActivity(intent2);
        });
        binding.imgbtn33.setOnClickListener(v -> {
            intent3.putExtra("title","Mechanical");
            startActivity(intent3);
        });
        binding.imgbtn44.setOnClickListener(v -> {
            intent4.putExtra("title","Electronics");
            startActivity(intent4);
        });
        binding.imgbtn55.setOnClickListener(v -> {
            intent5.putExtra("title","Electrical");
            startActivity(intent5);
        });


    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == R.id.m1){
            Intent intent =new Intent(getApplicationContext(), Assignment.class);
            intent.putExtra("subject","latest");
            intent.putExtra("title","latest Notes");
            startActivity(intent);
        }else if (itemid == R.id.m2){
            Uri uri = Uri.parse("https://amzn.to/462lKjK");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (itemid == R.id.m3){
            Uri uri = Uri.parse("https://www.youtube.com/@technicalguruji2471/videos");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else if (itemid == R.id.m4){
            Uri uri = Uri.parse("https://pagalmovie.site/about-us/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}