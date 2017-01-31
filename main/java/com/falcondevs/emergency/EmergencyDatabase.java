package com.falcondevs.emergency;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shubham on 28/1/17.
 */

public class EmergencyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "hospitalsList"; //the name of our database
    private static final int DB_VERSION = 3;
    EmergencyDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE HOSPITALS (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, Contact_no NUMERIC, LATITUDE NUMERIC, LONGITUDE NUMERIC);");
        insertHospital(db, "AIMS","8287236772", 77.0, 28.0);
        insertHospital(db, "FORTIS","9990368110", 70.0, 20.0);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }
    private static void insertHospital(SQLiteDatabase db, String name, String number, double latitude, double longitude){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("LATITUDE", latitude);
        contentValues.put("LONGITUDE", longitude);
        contentValues.put("Contact_no", number);
        db.insert("HOSPITALS", null, contentValues);
    }
}
