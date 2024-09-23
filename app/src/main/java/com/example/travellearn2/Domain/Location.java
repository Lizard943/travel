package com.example.travellearn2.Domain;

import androidx.annotation.NonNull;

public class Location {
    private int id;
    private String loc;

    public Location() {

    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return loc;
    }
}
