package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zero.drivesafe.databinding.ActivityMainBinding;
import com.zero.drivesafe.databinding.NavHeaderBinding;
import com.zero.drivesafe.fragments.DashboardFragment;
import com.zero.drivesafe.fragments.ProfileFragment;
import com.zero.drivesafe.fragments.ReportFragment;
import com.zero.drivesafe.fragments.TripDetailFragment;

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

        navHeaderBinding.navClose.setOnClickListener(view -> activityMainBinding.drawLayout.close());//for closing navigation menu

        View mainView = activityMainBinding.getRoot();
        setContentView(mainView);


        activityMainBinding.bottomNavBar.setOnItemSelectedListener(item -> {
                    int itemID = item.getItemId();
                    if (itemID == R.id.dashboard_bottom_nav_btn) {
                        replaceFragment(new DashboardFragment(), activityMainBinding.fragmentContainer);
                    } else if (itemID == R.id.report_bottom_nav_btn) {
                        replaceFragment(new ReportFragment(), activityMainBinding.fragmentContainer);
                    } else if (itemID == R.id.profile_bottom_nav_btn) {
                        replaceFragment(new ProfileFragment(), activityMainBinding.fragmentContainer);
                    } else {
                        Toast.makeText(this, "???", Toast.LENGTH_SHORT).show();
                    }

                    return true; //Because it require return value
                }
        );


    }

    public void replaceFragment(Fragment fragment, FragmentContainerView fragmentContainer) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer.getId(), fragment);
        fragmentTransaction.commit();
    }
}