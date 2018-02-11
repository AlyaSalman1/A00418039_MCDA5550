package com.example.lenovo.newproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.*;

import android.content.ContentValues;
import android.widget.EditText;

/**
 * Created by Lenovo on 2/3/2018.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "Database";  // name of the DBprivate //
    private static final int DB_VERSION = 1;  // version of the DBpublic
    public static final String UserInfo = "user";
    public static final String BMICal = "BMI";

    // name of the Table
    public SQLiteDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + UserInfo + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "PASSWORD TEXT," + "HEALTH_CARD_NUM TEXT,"
                + "EMAIL TEXT, " + "DOB TEXT);");
        db.execSQL("CREATE TABLE " + BMICal + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "HEIGHT DOUBLE, " + "WEIGHT DOUBLE,"
                + "BMI DOUBLE, " + "DATE TEXT);");
    }

    public void Insertuser(String name,String pass,String Email,String hcn,String date) {

        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME", name);
        personValues.put("PASSWORD", pass);
        personValues.put("HEALTH_CARD_NUM", hcn);
        personValues.put("EMAIL", Email);
        personValues.put("DOB", date);
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(UserInfo, null, personValues);
    }

    public void InsertBMI(Double height,Double weight, Double BMI) {
        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.CANADA).format(new Date());
        ContentValues personValues = new ContentValues();
        personValues.put("HEIGHT", height);
        personValues.put("WEIGHT", weight);
        personValues.put("BMI", BMI);
        personValues.put("DATE", date);
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(BMICal, null, personValues);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}