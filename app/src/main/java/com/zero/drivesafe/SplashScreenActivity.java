package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zero.drivesafe.databinding.ActivitySplashscreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
     ActivitySplashscreenBinding activitySplashscreenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashscreenBinding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(activitySplashscreenBinding.getRoot());

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
        }, 30);
    }
}