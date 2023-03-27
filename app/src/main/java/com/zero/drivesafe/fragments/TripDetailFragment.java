package com.zero.drivesafe.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zero.drivesafe.databinding.FragmentTripDetailBinding;
import com.zero.drivesafe.models.Ride;


public class TripDetailFragment extends Fragment {

    private Ride ride;
    private FragmentTripDetailBinding fragmentTripDetailBinding;

    public TripDetailFragment() {
        // Required empty public constructor
    }

    public TripDetailFragment(Ride ride) {
        this.ride = ride;
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide(); //for hiding toolbar
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().show(); //for showing toolbar after the fragment is closed

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String totalDistance = ride.getTotalDistance() + "";
        String highSpeed = ride.getHighestSpeed() + "";
        String totalAlerts = ride.getAlerts() + "";

        fragmentTripDetailBinding = FragmentTripDetailBinding.inflate(inflater, container, false);
        fragmentTripDetailBinding.sourceTv.setText(ride.getSource());
        fragmentTripDetailBinding.totalDistanceTv.setText(totalDistance);
        fragmentTripDetailBinding.timeTv.setText(ride.getTime());
        fragmentTripDetailBinding.highestSpeedTv.setText(highSpeed);
        fragmentTripDetailBinding.tvTotalAlerts.setText(totalAlerts);
        fragmentTripDetailBinding.backIv.setOnClickListener(view -> { //use requireActivity instead of getActivity to remove null Exceptions
            requireActivity().getSupportFragmentManager().beginTransaction().remove(this).commit(); //removing this fragment from stack
        });
        // Inflate the layout for this fragment
        return fragmentTripDetailBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentTripDetailBinding = null; //Destroy the view for memory saving
    }
}