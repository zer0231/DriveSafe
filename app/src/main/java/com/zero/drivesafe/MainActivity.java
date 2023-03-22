package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    NavigationView navigationView;
    ImageButton btnNavOpen,btnNavClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);//Adding toolbar
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.draw_layout);
        btnNavOpen = findViewById(R.id.tool_bar_nav_button);
        navigationView = findViewById(R.id.navigation_view);
        btnNavOpen.setOnClickListener(view -> {drawerLayout.open();}); //for opening navigation menu


        View headerLayout = navigationView.getHeaderView(0);
        btnNavClose = headerLayout.findViewById(R.id.nav_close);
        btnNavClose.setOnClickListener(view -> drawerLayout.close()); //for closing navigation menu
    }
}