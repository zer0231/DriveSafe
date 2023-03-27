package com.zero.drivesafe.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero.drivesafe.databinding.CardProfileBinding;
import com.zero.drivesafe.models.Driver;

import java.util.List;

public class DriveAdapter extends RecyclerView.Adapter<DriveAdapter.ViewHolder> {
    private final List<Driver> driverList;


    public DriveAdapter(List<Driver> driverList) {
        this.driverList = driverList;
    }

    @NonNull
    @Override
    public DriveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DriveAdapter.ViewHolder(CardProfileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DriveAdapter.ViewHolder holder, int position) {

        Driver driverObject = driverList.get(position);
        String totalTrip = "Total trip: " + driverObject.getTotal_trip();
        holder.cardProfileBinding.usernameTv.setText(driverObject.getName());
        holder.cardProfileBinding.emailTv.setText(driverObject.getEmail());
        holder.cardProfileBinding.totalTripTv.setText(totalTrip);

    }


    @Override
    public int getItemCount() {
        return driverList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardProfileBinding cardProfileBinding;

        public ViewHolder(@NonNull CardProfileBinding cardProfileBinding) {
            super(cardProfileBinding.getRoot());
            this.cardProfileBinding = cardProfileBinding;

        }
    }
}
