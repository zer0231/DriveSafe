package com.zero.drivesafe.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false);
        ArrayList<Ride> rideArrayList = new ArrayList<>();
        rideArrayList.add(new Ride("home", "home", "2 h 4 m", 2, 2, 2,45));
        rideArrayList.add(new Ride("home", "somewhere", "3 h 3 m", 2, 2, 2,80));
        rideArrayList.add(new Ride("home", "home", "2 h 1 m", 2, 2, 2,90));
        rideArrayList.add(new Ride("home", "home", "4 h 2 m", 2, 2, 2,65));
        RideAdapter rideAdapter = new RideAdapter(rideArrayList);
        dashboardBinding.dashboardRecyclerview.setLayoutManager(new LinearLayoutManager(dashboardBinding.dashboardRecyclerview.getContext()));
        dashboardBinding.dashboardRecyclerview.setAdapter(rideAdapter);

        return dashboardBinding.getRoot();
    }
}