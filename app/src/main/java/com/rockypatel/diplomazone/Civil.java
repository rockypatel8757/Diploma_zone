package com.rockypatel.diplomazone;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.rockypatel.diplomazone.databinding.ActivityCivilBinding;

import java.util.Objects;

public class Civil extends AppCompatActivity {
ActivityCivilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCivilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.tbc);
        String title=getIntent().getStringExtra("title");
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.ibc11.setImageResource(R.drawable.math);
        binding.ibc22.setImageResource(R.drawable.ap);
        binding.ibc33.setImageResource(R.drawable.ac);
        binding.ibc44.setImageResource(R.drawable.dg);
        binding.ibc55.setImageResource(R.drawable.mech);
        binding.ibc66.setImageResource(R.drawable.ws);

        binding.ibc11.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","mathcivil");
            intent.putExtra("title","Mathematics");
            startActivity(intent);
        });
        binding.ibc22.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","physicscivil");
            intent.putExtra("title","Engineering physics");
            startActivity(intent);
        });
        binding.ibc33.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","chemistrycivil");
            intent.putExtra("title","Engineering Chemistry");
            startActivity(intent);
        });
        binding.ibc44.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","drawinggraphics");
            intent.putExtra("title","Drawing & Graphics");
            startActivity(intent);
        });
        binding.ibc55.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","mechanics");
            intent.putExtra("title","Mechanics");
            startActivity(intent);
        });
        binding.ibc66.setOnClickListener(v->{
            Intent intent=new Intent(this,Study_material.class);
            intent.putExtra("subject","workshop");
            intent.putExtra("title","Work Shop & Environment");
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