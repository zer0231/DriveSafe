package com.zero.drivesafe.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.drivesafe.adapters.DriveAdapter;
import com.zero.drivesafe.databinding.FragmentProfileBinding;
import com.zero.drivesafe.models.Driver;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding profileBinding;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        profileBinding = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileBinding = FragmentProfileBinding.inflate(inflater, container, false);
        ArrayList<Driver> driverArrayList = new ArrayList<>();
        driverArrayList.add(new Driver("test", "test@test.com", 23));
        driverArrayList.add(new Driver("test", "test@test.com", 23));
        driverArrayList.add(new Driver("test", "test@test.com", 23));
        driverArrayList.add(new Driver("test", "test@test.com", 23));
        driverArrayList.add(new Driver("test", "test@test.com", 23));
        DriveAdapter driveAdapter = new DriveAdapter(driverArrayList);
        profileBinding.driverProfileRecyclerview.setLayoutManager(new LinearLayoutManager(profileBinding.driverProfileRecyclerview.getContext()));
        profileBinding.driverProfileRecyclerview.setAdapter(driveAdapter);
        return profileBinding.getRoot();
    }
}