package com.example.edmonton_tracker;

/**
 * Created by aapae on 3/20/2018.
 */

public class aBus {
    private int bus_number, bus_title, lat, lon, bear, trip_id;
    public void aBus(int bus_number, int bus_title, int lat, int lon, int bear, int trip_id){
        this.bus_number = bus_number;
        this.bus_title = bus_title;
        this.lat = lat;
        this.lon = lon;
        this.bear = bear;
        this.trip_id = trip_id;

    }

    public int getBus_number() {
        return bus_number;
    }

    public void setBus_number(int bus_number) {
        this.bus_number = bus_number;
    }

    public int getBus_title() {
        return bus_title;
    }

    public void setBus_title(int bus_title) {
        this.bus_title = bus_title;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getBear() {
        return bear;
    }

    public void setBear(int bear) {
        this.bear = bear;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }
}
