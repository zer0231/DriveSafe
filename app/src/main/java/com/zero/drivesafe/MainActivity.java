package com.zero.drivesafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zero.drivesafe.databinding.ActivityMainBinding;
import com.zero.drivesafe.databinding.NavHeaderBinding;
import com.zero.drivesafe.fragments.DashboardFragment;
import com.zero.drivesafe.fragments.ProfileFragment;
import com.zero.drivesafe.fragments.ReportFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View header = activityMainBinding.navigationView.getHeaderView(0);
        NavHeaderBinding navHeaderBinding = NavHeaderBinding.bind(header);

        setSupportActionBar(activityMainBinding.toolbar);

        activityMainBinding.toolBarNavButton.setOnClickListener(view -> activityMainBinding.drawLayout.open());//for opening navigation menu

        navHeaderBinding.navClose.setOnClickListener(view -> activityMainBinding.drawLayout.close());//for closing navigation menu

        View mainView = activityMainBinding.getRoot();
        setContentView(mainView);


        activityMainBinding.bottomNavBar.setOnItemSelectedListener(view -> {
                    int itemID = view.getItemId();
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

        activityMainBinding.navigationView.setNavigationItemSelectedListener(view -> {
            int itemID = view.getItemId();
            if (itemID == R.id.profile_nav_drawer) {
                replaceFragment(new ProfileFragment(), activityMainBinding.fragmentContainer);
                activityMainBinding.bottomNavBar.setSelectedItemId(R.id.profile_bottom_nav_btn);
            }
            activityMainBinding.drawLayout.close();
            return true;
        });
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        activityMainBinding.dateAndTime.setText(formatter.format(new Date()));

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Exiting", Toast.LENGTH_SHORT).show();
        finish(); //finishAffinity() removes all the activities that share the same affinity<indicates which task an activity belongs to>
    }

    public void replaceFragment(Fragment fragment, FragmentContainerView fragmentContainer) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer.getId(), fragment);
        fragmentTransaction.commit();
    }
}