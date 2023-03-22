package com.zero.drivesafe.models;

public class Ride {
    String destination,source,time;
    int alerts;
    int totalDistance;
    int highestSpeed;

    public Ride(String destination,String source,String time,int alerts,int totalDistance,int highestSpeed){
        this.destination = destination;
        this.source = source;
        this.time = time;
        this.alerts = alerts;
        this.totalDistance = totalDistance;
        this.highestSpeed = highestSpeed;
    }


}
