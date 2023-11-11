package com.rockypatel.diplomazone;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.rockypatel.diplomazone.databinding.ActivityComputerScienceBinding;

public class ComputerScience extends AppCompatActivity {
    ActivityComputerScienceBinding binding;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityComputerScienceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title=getIntent().getStringExtra("title");
        setSupportActionBar(binding.tbcs);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        binding.ibcs11.setImageResource(R.drawable.cs);
        binding.ibcs22.setImageResource(R.drawable.math);
        binding.ibcs33.setImageResource(R.drawable.coms);
        binding.ibcs44.setImageResource(R.drawable.it);
        binding.ibcs55.setImageResource(R.drawable.ac);
        binding.ibcs66.setImageResource(R.drawable.ap);




        binding.ibcs11.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","cs_cg");
            intent.putExtra("title","Computer Graphics");
            startActivity(intent);
        });
        binding.ibcs22.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","mathcs");
            intent.putExtra("title","Mathematics");
            startActivity(intent);
        });
        binding.ibcs33.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","communication");
            intent.putExtra("title","Communication Skill");
            startActivity(intent);
        });
        binding.ibcs44.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","infotech");
            intent.putExtra("title","Information Technology");
            startActivity(intent);
        });
        binding.ibcs55.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","appliedchem");
            intent.putExtra("title","Engineering Chemistry");
            startActivity(intent);
        });
        binding.ibcs66.setOnClickListener(v -> {
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","appliedphysics");
            intent.putExtra("title","Engineering Physics");
            startActivity(intent);
        });




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