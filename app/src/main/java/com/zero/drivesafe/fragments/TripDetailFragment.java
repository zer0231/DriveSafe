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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TripDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Ride ride;
    FragmentTripDetailBinding fragmentTripDetailBinding;

    public TripDetailFragment() {
        // Required empty public constructor
    }

    public TripDetailFragment(Ride ride) {
        this.ride = ride;
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TripdetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TripDetailFragment newInstance(String param1, String param2) {

        TripDetailFragment fragment = new TripDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String totalDistance = ride.getTotalDistance() + "";
        String highSpeed = ride.getHighestSpeed() + "";
        String totalAlerts = ride.getAlerts() + "";
        // Inflate the layout for this fragment
        fragmentTripDetailBinding = FragmentTripDetailBinding.inflate(inflater, container, false);
        fragmentTripDetailBinding.sourceTv.setText(ride.getSource());
        fragmentTripDetailBinding.totalDistanceTv.setText(totalDistance);
        fragmentTripDetailBinding.timeTv.setText(ride.getTime());
        fragmentTripDetailBinding.highestSpeedTv.setText(highSpeed);
        fragmentTripDetailBinding.tvTotalAlerts.setText(totalAlerts);
        fragmentTripDetailBinding.backIv.setOnClickListener(view -> {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit(); //removing this fragment from stack
        });
        return fragmentTripDetailBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentTripDetailBinding = null;
    }
}