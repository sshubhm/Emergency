package com.falcondevs.emergency;

import android.Manifest;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.Intent.ACTION_DIAL;

public class HospitalActivity extends ListActivity {

    ArrayList<String> name = new ArrayList<String>();
    ArrayList<Double> distance = new ArrayList<>();
    ArrayList<String> contact = new ArrayList<>();
    private SQLiteDatabase db;
    private Cursor cursor;


    Context a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();

        try {
            SQLiteOpenHelper emergencyDatabaseHelper = new EmergencyDatabase(this);

            db = emergencyDatabaseHelper.getReadableDatabase();
            cursor = db.query("HOSPITALS", new String[]{"NAME", "_id", "LATITUDE", "LONGITUDE", "Contact_no"}, null, null, null, null, null, null);
            cursor.moveToFirst();

            while (cursor.isAfterLast() == false) {
                double lat = cursor.getDouble(2);
                double lon = Double.parseDouble(cursor.getString(3));
                Location hospitalLocation = new Location("dummyprovider");
                hospitalLocation.setLatitude(lat);
                hospitalLocation.setLongitude(lon);
                Location currentLocation = getIntent().getParcelableExtra("current");
                if(currentLocation == null){
                    throw new ArrayIndexOutOfBoundsException("null");
                }
                double distance1 = currentLocation.distanceTo(hospitalLocation);
                name.add(cursor.getString(0));
                contact.add(cursor.getString(4));
                distance.add(distance1);
                cursor.moveToNext();
            }
            sort();
            Collections.reverse(distance);
            Collections.reverse(name);
            Collections.reverse(contact);

      /*      CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAME", "Contact_no"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(listAdapter);
*/
            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    name);
            listView.setAdapter(listAdapter);


            //Add the listener to the list view
        } catch (ArrayIndexOutOfBoundsException e) {
            Toast toast = Toast.makeText(this, e + "", Toast.LENGTH_SHORT);
            toast.show();
        }



    }


    /*public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String s = hospital.get(position).contact;
        intent.setData(Uri.parse("tel:011" + s));
        startActivity(intent);
*/
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:011" + contact.get(position)));
        startActivity(intent);

    }
    public void sort(){
        double d;
        for(int i = 0; i < distance.size(); i++){
            d = distance.get(i);
            for(int j = i+1; j < distance.size(); j++){
                if(d < distance.get(j)){
                    d = distance.get(j);
                    double temp = distance.get(i);
                    distance.set(i, d);
                    distance.set(j, temp);
                    String t = name.get(i);
                    name.set(i, name.get(j));
                    name.set(j, t);

                    String t1 = contact.get(i);
                    contact.set(i, contact.get(j));
                    contact.set(j, t1);



                }
            }
        }

    }



}
