package com.example.lenovo.newproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.*;

import android.content.ContentValues;
import android.widget.EditText;

/**
 * Created by Lenovo on 2/3/2018.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "inclass";  // name of the DBprivate //
    private static final int DB_VERSION = 1;  // version of the DBpublic
    public static final String TABLE_NAME = "PERSON";

    // name of the Table
    public SQLiteDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "PASSWORD TEXT,"
                + "HEALTH_CARD_NUMB TEXT, " + "DATE INTEGER);");
        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME", "Dan Penny");
        personValues.put("PASSWORD", "Super Secret");
        personValues.put("HEALTH_CARD_NUMB", "1234 5678 9101");
        personValues.put("DATE", today.getTime());
        db.insert(TABLE_NAME, null, personValues);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}