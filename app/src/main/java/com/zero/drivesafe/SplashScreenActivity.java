package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zero.drivesafe.databinding.ActivitySplashscreenBinding;

public class SplashScreenActivity extends AppCompatActivity {
     ActivitySplashscreenBinding activitySplashscreenBinding;
    int TIME_IN_SECOND = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashscreenBinding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(activitySplashscreenBinding.getRoot());

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
        }, TIME_IN_SECOND * 1000L);
    }
}