package com.zero.drivesafe.adapters;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero.drivesafe.databinding.CardDashboardBinding;
import com.zero.drivesafe.fragments.DashboardFragment;
import com.zero.drivesafe.fragments.TripDetailFragment;
import com.zero.drivesafe.models.Ride;

import java.util.ArrayList;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolder> {
    public ArrayList<Ride> RideArrayList;
    public CardDashboardBinding cardDashboardBinding;

    public RideAdapter(ArrayList<Ride> RideArrayList) {
        this.RideArrayList = RideArrayList;

    }

    @NonNull
    @Override
    public RideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cardDashboardBinding = CardDashboardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(cardDashboardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RideAdapter.ViewHolder holder, int position) {
        Ride rideObject = RideArrayList.get(position);
        String alert = "Total Alerts: " + rideObject.getAlerts();
        String totalDistance = rideObject.getTotalDistance() + " Km";
        String highestSpeed = rideObject.getHighestSpeed() + " Km/h";
        holder.cardDashboardBinding.destinationTv.setText(rideObject.getDestination());
        holder.cardDashboardBinding.sourceTv.setText(rideObject.getSource());
        holder.cardDashboardBinding.timeTv.setText(rideObject.getTime());
        holder.cardDashboardBinding.alertTv.setText(alert);
        holder.cardDashboardBinding.totalDistanceTv.setText(totalDistance);
        holder.cardDashboardBinding.highestSpeedTv.setText(highestSpeed);
        holder.cardDashboardBinding.dashboardCard.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return RideArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CardDashboardBinding cardDashboardBinding;

        public ViewHolder(@NonNull CardDashboardBinding cardDashboardBinding) {
            super(cardDashboardBinding.getRoot());
            this.cardDashboardBinding = cardDashboardBinding;
        }
    }
}