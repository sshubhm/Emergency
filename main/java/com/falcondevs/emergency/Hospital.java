package com.falcondevs.emergency;

import android.widget.ArrayAdapter;

/**
 * Created by shubham on 28/1/17.
 */

public class Hospital {
    public String name;
    public boolean latitude;
    public boolean longitude;

    Hospital(String name, boolean latitude, boolean longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
