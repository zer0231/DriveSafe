package com.zero.drivesafe.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.drivesafe.R;
import com.zero.drivesafe.adapters.RideAdapter;
import com.zero.drivesafe.databinding.FragmentDashboardBinding;
import com.zero.drivesafe.models.Ride;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    FragmentDashboardBinding dashboardBinding;

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
        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false);
        ArrayList<Ride> rideArrayList = new ArrayList<>();
        rideArrayList.add(new Ride("1", "home", "2 h 4 m", 2, 2, 2, 100));
        rideArrayList.add(new Ride("2", "somewhere1", "3 h 3 m", 2, 2, 2, 80));
        rideArrayList.add(new Ride("3", "somewhere", "3 h 3 m", 2, 2, 2, 80));
        rideArrayList.add(new Ride("4", "somewhere", "3 h 3 m", 2, 2, 2, 80));

        RideAdapter rideAdapter = new RideAdapter(requireContext(), rideArrayList, requireActivity().findViewById(R.id.fragment_container));
        dashboardBinding.dashboardRecyclerview.setLayoutManager(new LinearLayoutManager(dashboardBinding.dashboardRecyclerview.getContext()));
        dashboardBinding.dashboardRecyclerview.setAdapter(rideAdapter);
        return dashboardBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dashboardBinding = null;
    }
}