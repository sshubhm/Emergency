package com.falcondevs.emergency;

import android.widget.ArrayAdapter;

/**
 * Created by shubham on 28/1/17.
 */

public class Hospital {
    public String name;
    public String latitude;
    public String longitude;
    public String contact;
    public double distance;

    public Hospital(String name, String latitude, String longitude, String contact, double distance){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contact = contact;
        this.distance = distance;

    }

}
