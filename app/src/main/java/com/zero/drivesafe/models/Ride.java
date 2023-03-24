package com.zero.drivesafe.models;

public class Ride {
    private String destination, source, time;
    private int alerts;
    private int totalDistance;
    private int highestSpeed;
    private int progress;

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

    public int getProgress() {
        return progress;
    }

    public Ride(String destination, String source, String time, int alerts, int totalDistance, int highestSpeed, int progress) {
        this.destination = destination;
        this.source = source;
        this.time = time;
        this.alerts = alerts;
        this.totalDistance = totalDistance;
        this.highestSpeed = highestSpeed;
        this.progress = progress;
    }

    public int getAlerts() {
        return alerts;
    }
}
