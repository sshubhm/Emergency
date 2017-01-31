package com.falcondevs.emergency;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends ListActivity {
    ArrayList<String> cn = new ArrayList<String>();
    private SQLiteDatabase db;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        try{
            SQLiteOpenHelper emergencyDatabaseHelper = new EmergencyDatabase(this);

            db = emergencyDatabaseHelper.getReadableDatabase();
            cursor = db.query("HOSPITALS", new String[] { "NAME" , "_id", "LONGITUDE", "LATITUDE", "Contact_no"},null , null ,null ,null, null, null);
            cursor.moveToFirst();
            while(cursor.isAfterLast()==false){
                cn.add(cursor.getString(4));
                cursor.moveToNext();
            }

            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[] {"NAME", "Contact_no"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(listAdapter);

        }

        catch (SQLiteException e){
            Toast toast = Toast.makeText(this, e +"", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onListItemClick(ListView listView,
                                  View itemView,
                                  int position,
                                  long id){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String s = cn.get(position);
        intent.setData(Uri.parse("tel:" + s));
        startActivity(intent);



    }
}
