package com.rockypatel.diplomazone;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.rockypatel.diplomazone.databinding.ActivityStudyMaterialBinding;

import java.util.Objects;

public class Study_material extends AppCompatActivity {
    ActivityStudyMaterialBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityStudyMaterialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.tbsm);
        String title=getIntent().getStringExtra("title");
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String subject= getIntent().getStringExtra("subject");

        binding.ibs1.setImageResource(R.drawable.book);
        binding.ibs2.setImageResource(R.drawable.notes);
        binding.ibs3.setImageResource(R.drawable.practical);
        binding.ibs4.setImageResource(R.drawable.assignment);

        Intent intent1 = new Intent(getApplicationContext(), Assignment.class);


        if (Objects.equals(subject, "cs_cg")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_eg_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_eg_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_eg_pract");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_eg_assign");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        } else if (Objects.equals(subject, "mathcs")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_math_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_math_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_math_prac");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_eg_ass");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        }else if (Objects.equals(subject, "communication")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_com_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_com_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_com_prac");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_com_ass");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        }else if (Objects.equals(subject, "infotech")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_itws_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_itws_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_itws_prac");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_itws_ass");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        }else if (Objects.equals(subject, "appliedchem")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_chem_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_chem_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_chem_prac");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_chem_ass");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        }else if (Objects.equals(subject, "appliedphysics")){
            binding.ibs1.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_phy_book");
                intent.putExtra("title","Book");
                startActivity(intent);
            });
            binding.ibs2.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_phy_notes");
                intent.putExtra("title","Notes");
                startActivity(intent);
            });
            binding.ibs3.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_phy_prac");
                intent.putExtra("title","Practical");
                startActivity(intent);
            });
            binding.ibs4.setOnClickListener(v->{
                Intent intent = new Intent(getApplicationContext(), Assignment.class);
                intent.putExtra("subject","cs_phy_ass");
                intent.putExtra("title","Assignment");
                startActivity(intent);
            });
        } else if (Objects.equals(subject, "mathcivil")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_math_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_math_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_math_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_math_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }else if (Objects.equals(subject, "physicscivil")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_phy_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_phy_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_phy_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_phy_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }else if (Objects.equals(subject, "chemistrycivil")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_chem_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_chem_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_chem_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_chem_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }else if (Objects.equals(subject, "drawinggraphics")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_gd_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_gd_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_gd_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_gd_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }else if (Objects.equals(subject, "mechanics")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_mech_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_mech_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_mech_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_mech_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }else if (Objects.equals(subject, "workshop")){
            binding.ibs1.setOnClickListener(v->{
                intent1.putExtra("subject","cv_wsev_book");
                intent1.putExtra("title","Book");
                startActivity(intent1);
            });
            binding.ibs2.setOnClickListener(v->{
                intent1.putExtra("subject","cv_wsev_notes");
                intent1.putExtra("title","Notes");
                startActivity(intent1);
            });
            binding.ibs3.setOnClickListener(v->{
                intent1.putExtra("subject","cv_wsev_prac");
                intent1.putExtra("title","Practical");
                startActivity(intent1);
            });
            binding.ibs4.setOnClickListener(v->{
                intent1.putExtra("subject","cv_wsev_ass");
                intent1.putExtra("title","Assignment");
                startActivity(intent1);
            });
        }





















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