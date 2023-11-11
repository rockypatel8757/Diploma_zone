package com.rockypatel.diplomazone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.MobileAds;
import com.rockypatel.diplomazone.Ads.InterstitialAds;
import com.rockypatel.diplomazone.databinding.ActivityPdfViewBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PdfView extends AppCompatActivity {
    private boolean isHandlerExecuted = false;
    ActivityPdfViewBinding binding;
    String chapter,pdflink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPdfViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (InterstitialAds.mInterstitialAd==null){
            InterstitialAds.interads(this);
        }



        chapter=getIntent().getStringExtra("chapter");
        pdflink=getIntent().getStringExtra("pdflink");


        if (!isHandlerExecuted) {
            executeHandler();
            isHandlerExecuted = true;
        }



//        BannerAd implementation
        MobileAds.initialize(getApplicationContext());
        AdRequest adreq = new AdRequest.Builder().build();
        binding.adView.loadAd(adreq);
        try {
            pdfshow(pdflink);
        }catch (Exception exception){

            if (Objects.equals(exception.getMessage(), "Could not reach Cloud Firestore backend")) {
                // Display a toast message
                Toast.makeText(getApplicationContext(), "Unable to connect to the server. Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        }



        if (isConnected()){

        }else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(this)
                    .setTitle("Internet")
                    .setMessage("Internet not Connected")
                    .setIcon(R.drawable.nosignal)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(PdfView.this, PdfView.class);
                            startActivity(intent);
                        }
                    });
            builder.show();
        }

    }

    private void pdfshow(String pdflink) {
        OkHttpClient okhttp=new OkHttpClient();
        Request request= new Request.Builder().url(pdflink).build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //Toast.makeText(PdfView.this, "Error", Toast.LENGTH_SHORT).show();
                Log.d("failed error",e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                assert response.body() != null;
                InputStream inputStream= response.body().byteStream();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.pdfv.fromStream(inputStream)
                                .onLoad(nbPages -> binding.pgbr.setVisibility(View.GONE)).load();
                    }
                });
            }
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

    public void adviewer(){

        if (InterstitialAds.mInterstitialAd!=null){
            InterstitialAds.mInterstitialAd.show(this);
            InterstitialAds.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    try {
                        // Clean up resources and handle ad dismissal
                        InterstitialAds.mInterstitialAd = null;
                        InterstitialAds.interads(getApplicationContext());
                    } catch (Exception e) {
                        Log.e("Ad Dismiss Error", "Error during ad dismissal: " + e.getMessage());
                    }

                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);

                }
            });
        }
    }

    private void executeHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adviewer();
            }
        }, 5 * 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adviewer();
            }
        }, 60 * 10 * 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adviewer();
            }
        }, 60 * 20 * 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adviewer();

            }
        }, 60 * 30 * 1000);
    }

}