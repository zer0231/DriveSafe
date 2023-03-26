package com.zero.drivesafe.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.drivesafe.R;
import com.zero.drivesafe.databinding.FragmentProfileBinding;
import com.zero.drivesafe.databinding.FragmentReportBinding;

public class ReportFragment extends Fragment {
FragmentReportBinding fragmentReportBinding;

    public ReportFragment() {
        // Required empty public constructor
    }

    public static ReportFragment newInstance(String param1, String param2) {
        ReportFragment fragment = new ReportFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentReportBinding = FragmentReportBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return fragmentReportBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentReportBinding = null;
    }
}