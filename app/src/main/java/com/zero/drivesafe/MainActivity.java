package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.zero.drivesafe.databinding.ActivityMainBinding;
import com.zero.drivesafe.databinding.NavHeaderBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    NavHeaderBinding navHeaderBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View header = activityMainBinding.navigationView.getHeaderView(0);
        navHeaderBinding = NavHeaderBinding.bind(header);

        setSupportActionBar(activityMainBinding.toolbar);

        activityMainBinding.toolBarNavButton.setOnClickListener(view -> activityMainBinding.drawLayout.open());//for opening navigation menu

        navHeaderBinding.navClose.setOnClickListener(view ->  activityMainBinding.drawLayout.close());//for closing navigation menu

        View mainView = activityMainBinding.getRoot();
        setContentView(mainView);

    }
}