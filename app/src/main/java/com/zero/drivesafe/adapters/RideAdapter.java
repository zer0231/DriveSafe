package com.zero.drivesafe.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;

import com.zero.drivesafe.R;
import com.zero.drivesafe.databinding.CardDashboardBinding;
import com.zero.drivesafe.fragments.TripDetailFragment;
import com.zero.drivesafe.models.Ride;

import java.util.ArrayList;
import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolder> {
    public ArrayList<Ride> RideArrayList;
    private final Context parentContext;
    private final FragmentContainerView parentFragmentContainer;

    public RideAdapter(Context parentContext, ArrayList<Ride> RideArrayList, FragmentContainerView parentFragmentContainer) {  //Take all the required items from the constructor instead of declaring again
        this.parentContext = parentContext;
        this.RideArrayList = RideArrayList;
        this.parentFragmentContainer = parentFragmentContainer;
    }

    @NonNull
    @Override
    public RideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CardDashboardBinding.inflate(LayoutInflater.from(parentContext), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RideAdapter.ViewHolder holder, int position) {
        Ride rideObject = RideArrayList.get(position);
        int progress = rideObject.getProgress();
        if (progress > 75 && progress < 100) {
            holder.cardDashboardBinding.circularProgress.setIndicatorColor(ContextCompat.getColor(parentContext, R.color.ok));
        } else if (progress > 55 && progress < 74) {
            holder.cardDashboardBinding.circularProgress.setIndicatorColor(ContextCompat.getColor(parentContext, R.color.warning));
        } else {
            holder.cardDashboardBinding.circularProgress.setIndicatorColor(ContextCompat.getColor(parentContext, R.color.error));
        }
        String progressText = progress + " %";
        holder.cardDashboardBinding.progressText.setText(progressText);
        holder.cardDashboardBinding.circularProgress.setProgress(progress);
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
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .add(parentFragmentContainer.getId(), new TripDetailFragment(rideObject),"TRIP_DETAIL_FRAGMENT")
                    .commit();
        });
    }


    @Override
    public int getItemCount() {
        return RideArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardDashboardBinding cardDashboardBinding;

        public ViewHolder(@NonNull CardDashboardBinding cardDashboardBinding) {
            super(cardDashboardBinding.getRoot());
            this.cardDashboardBinding = cardDashboardBinding;
        }
    }
}
