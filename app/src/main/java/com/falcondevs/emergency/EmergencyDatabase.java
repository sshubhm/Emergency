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
    private static final int DB_VERSION = 1;
    EmergencyDatabase(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE HOSPITALS (" + "_id INTEGER, " + "NAME TEXT, Contact_no NUMERIC,Contact_no2 NUMERIC, LATITUDE NUMERIC, LONGITUDE NUMERIC);");
        insertHospital(db,1, "Aruna Asaf Ali Govt. Hospital","23983618", "23965532", 28.669794, 77.217818);
        insertHospital(db,2, "Acharyaashree Bhikshu Hospital","25423011", "25101552",28.661789, 77.140438);
        insertHospital(db,3, "Attar Sain Jain Hospital","27188342", "23654664",28.661789, 77.140438);
        insertHospital(db,4, "Baba Saheb Ambedkar Hospital" ,"27055585" ,"27933256",28.714607, 77.113502);
        insertHospital(db,5, "Bhagwan Mahaveer Hospital" ,"27034537" ,"27034540",28.688452, 77.117971);
        insertHospital(db,6, "Babu Jagjivan Ram Hospital" ,"27634634" ,"27636955",28.734882, 77.172681 );
        insertHospital(db,7, "Central Jail Hospital" ,"28520012" ,"",28.624832, 77.110884 );
        insertHospital(db,8, "Chacha Nehru Bal Chikitsalaya" ,"22013373" ,"22013374", 28.652981, 77.268561);
        insertHospital(db,9, "Dadadev Mother & Child Hospital" ,"25395528" ,"25395536", 28.609217, 77.082736);
        insertHospital(db,10, "Deen Dayal Upadhyay Hospital" ,"25494402" ,"25494403", 28.627450, 77.113101);
        insertHospital(db,11, "Deep Chand Bandhu Hospital" ,"27301374" ,"", 28.681774, 77.178286);
        insertHospital(db,12, "Delhi State Cancer Institution" ,"22110505" ,"",28.686181, 77.309082 );
        insertHospital(db,13, "Dr. Hedgewar Arogya Sansthan" ,"22382686" ,"22393155", 28.655977, 77.293415);
        insertHospital(db,14, "Dr. N.C. Joshi Hospital" ,"23611786" ,"23622498", 28.652256, 77.199247);
        insertHospital(db,15, "Govind Ballabh Pant Hospital (G.B.P.H.)" ,"23234242" ,"23233001", 28.638740, 77.234819);
        insertHospital(db,16, "Guru Govind Singh Govt. Hospital" ,"25986410" ,"25986411", 28.652989, 77.107201);
        insertHospital(db,17, "Guru Teg Bahadur Hospital (G.T.B.H.)" ,"22586262" ,"22588383", 28.683768, 77.309968);
        insertHospital(db,18, "Janakpuri Super Speciality Hospital" ,"28504100" ,"", 28.620669, 77.089721);
        insertHospital(db,19, "Lal Bahadur Shastri Hospital (L.B.S.)" ,"22731394" ,"22786688", 28.617832, 77.311391);
        insertHospital(db,20, "Lok Nayak Hospital" ,"23236000" ,"23232400", 28.638779, 77.238323);
        insertHospital(db,21, "Maharishi Balmiki Hospital" ,"27761524" ,"27761525", 28.775791, 77.048585);
        insertHospital(db,22, "Pt. Madan Mohan Malviya Hospital" ,"26689999" ,"26672534", 28.535621, 77.213911);
        insertHospital(db,23, "Rajiv Gandhi Super Speciality Hospital" ,"22312211" ,"22312244", 28.689277, 77.316594);
        insertHospital(db,24, "Rao Tula Ram Memorial Hospital" ,"25318070" ,"25318444", 28.594698, 76.914036);
        insertHospital(db,25, "Sardar Vallabh Bhai Patel Hospital" ,"25881201" ,"25885944", 28.647005, 77.169050);
        insertHospital(db,26, "Satyawadi Raja Harish Chandra Hospital" ,"27787304" ,"",28.840887, 77.102029);
        insertHospital(db,27,"Sanjay Gandhi Memorial Hospital" ,"27913864", "27900333", 28.692705, 77.081840);
        insertHospital(db,28, "Jag Parvesh Chander Hospital" ,"22184455" ,"22184453", 28.676235, 77.262908);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }
    private static void insertHospital(SQLiteDatabase db,int id, String name, String number, String number2, double latitude, double longitude){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("_id", id);

        contentValues.put("LATITUDE", latitude);
        contentValues.put("LONGITUDE", longitude);
        contentValues.put("Contact_no", number);
        contentValues.put("Contact_no2", number2);
        db.insert("HOSPITALS", null, contentValues);
    }
}
