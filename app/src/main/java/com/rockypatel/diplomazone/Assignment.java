package com.rockypatel.diplomazone;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.rockypatel.diplomazone.Adapter.RecAdapter;
import com.rockypatel.diplomazone.Adapter.mModel;
import com.rockypatel.diplomazone.databinding.ActivityAssignmentBinding;

import java.util.ArrayList;
import java.util.Objects;

public class Assignment extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView.Adapter adapter;
    ArrayList<mModel> arrayList;
    ActivityAssignmentBinding binding;
    String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAssignmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(getApplicationContext());
        AdRequest adreq = new AdRequest.Builder().build();
        binding.adView.loadAd(adreq);

        setSupportActionBar(binding.tbc);
        String title=getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (isConnected()){

        }else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(this)
                    .setTitle("Internet")
                    .setMessage("Please Connect to Internet!")
                    .setIcon(R.drawable.nosignal)
                    .setPositiveButton("ok", (dialog, which) -> {
                        Intent intent = new Intent(Assignment.this, Study_material.class);
                        startActivity(intent);
                    });
            builder.show();
        }


        arrayList=new ArrayList<>();
        firestore= FirebaseFirestore.getInstance();
        adapter= new RecAdapter(this,arrayList);
        binding.mrec.setAdapter(adapter);
        binding.mrec.setLayoutManager(new LinearLayoutManager(this));
        binding.pgb.setVisibility(View.VISIBLE);
        subject=getIntent().getStringExtra("subject");
        LoadData(subject);


    }

    @SuppressLint("NotifyDataSetChanged")
    private void LoadData(String chapter) {
//        arrayList.clear();
        firestore.collection(chapter).orderBy("id", Query.Direction.ASCENDING)
                .addSnapshotListener((value, error) -> {

                    if (error != null){
                        Toast.makeText(this, "Chapter Loaded", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    for (DocumentChange dc : Objects.requireNonNull(value).getDocumentChanges()){
                        if (dc.getType()==DocumentChange.Type.ADDED){
                            arrayList.add(dc.getDocument().toObject(mModel.class));
                        }
                        adapter.notifyDataSetChanged();
                    }
                    binding.pgb.setVisibility(View.GONE);


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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == R.id.m1){
            Intent intent =new Intent(getApplicationContext(), Assignment.class);
            intent.putExtra("subject","latest");
            intent.putExtra("title","latest Notes");
            startActivity(intent);
        }else if (itemid == R.id.m2){
            Uri uri = Uri.parse("https://amzn.to/462lKjK"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (itemid == R.id.m3){
            Uri uri = Uri.parse("https://www.youtube.com/@technicalguruji2471/videos"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else if (itemid == R.id.m4){
            Uri uri = Uri.parse("https://pagalmovie.site/about-us/"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}