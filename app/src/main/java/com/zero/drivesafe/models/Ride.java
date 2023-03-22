package com.zero.drivesafe.models;

public class Ride {
    String destination, source, time;
    int alerts;
    int totalDistance;
    int highestSpeed;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAlerts(int alerts) {
        this.alerts = alerts;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getHighestSpeed() {
        return highestSpeed;
    }

    public void setHighestSpeed(int highestSpeed) {
        this.highestSpeed = highestSpeed;
    }

    public Ride(String destination, String source, String time, int alerts, int totalDistance, int highestSpeed) {
        this.destination = destination;
        this.source = source;
        this.time = time;
        this.alerts = alerts;
        this.totalDistance = totalDistance;
        this.highestSpeed = highestSpeed;
    }

    public int getAlerts() {
        return alerts;
    }
}