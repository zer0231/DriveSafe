package com.zero.drivesafe.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.zero.drivesafe.adapters.RideAdapter;
import com.zero.drivesafe.databinding.FragmentDashboardBinding;
import com.zero.drivesafe.models.Ride;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentDashboardBinding dashboardBinding;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }
    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false);
        ArrayList<Ride> rideArrayList = new ArrayList<>();
        rideArrayList.add(new Ride("home", "home", "2 h", 2, 2, 2));
        rideArrayList.add(new Ride("home", "home", "3 h", 2, 2, 2));
        rideArrayList.add(new Ride("home", "home", "2 h", 2, 2, 2));
        rideArrayList.add(new Ride("home", "home", "4 h", 2, 2, 2));
        RideAdapter rideAdapter = new RideAdapter(rideArrayList);
        dashboardBinding.dashboardRecyclerview.setLayoutManager(new LinearLayoutManager(dashboardBinding.dashboardRecyclerview.getContext()));
        dashboardBinding.dashboardRecyclerview.setAdapter(rideAdapter);

        return dashboardBinding.getRoot();
    }
}