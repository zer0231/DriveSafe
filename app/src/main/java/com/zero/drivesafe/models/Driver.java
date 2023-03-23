package com.zero.drivesafe.models;

public class Driver {
    private String name, email;
    private int total_trip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotal_trip() {
        return total_trip;
    }

    public void setTotal_trip(int total_trip) {
        this.total_trip = total_trip;
    }

    public Driver(String name, String email, int total_trip) {
        this.name = name;
        this.email = email;
        this.total_trip = total_trip;
    }
}
