package com.example.lenovo.newproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.*;

import android.content.ContentValues;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Lenovo on 2/3/2018.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "Database";  // name of the DBprivate //
    private static final int DB_VERSION = 1;  // version of the DBpublic
    public static final String UserInfo = "user";
    public static final String BMICal = "BMICal";

    public static final String TABLE_COLUMN_ID ="_id";
    public static final String TABLE_COLUMN_DATE ="date";
    public static final String TABLE_COLUMN_BMI = "bmi";
    public static final String TABLE_COLUMN_NAME = "weight";



    // name of the Table
    public SQLiteDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


      //  db.execSQL("drop table BMICal");
        db.execSQL("CREATE TABLE " + UserInfo + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "PASSWORD TEXT," + "HEALTH_CARD_NUM TEXT,"
                + "EMAIL TEXT, " + "DOB TEXT);");

        Log.i("AppCall","Abt to create table BMICAL");
      //  db.execSQL("CREATE TABLE " + BMICal + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "HEIGHT TEXT, " + "WEIGHT TEXT,"
     //           + "BMI TEXT, " + "DATE TEXT);");

        db.execSQL ("create table bmical "+"(_id integer primary key autoincrement , height text, weight text, bmi text, date text)");
        Log.d("Dbcall","BMICAl table created successfully") ;
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
    public void Updateuser(String name,String pass,String Email,String hcn,String date) {
        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME", name);
        personValues.put("PASSWORD", pass);
        personValues.put("HEALTH_CARD_NUM", hcn);
        personValues.put("EMAIL", Email);
        personValues.put("DOB", date);
        SQLiteDatabase db= this.getWritableDatabase();
        db.update(UserInfo, personValues, "EMAIL = ?",new String[]{Email});
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
    public void UpdatePass(String pass,String Email) {


        ContentValues personValues = new ContentValues();
        personValues.put("PASSWORD", pass);
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(UserInfo, null, personValues);
        db.update(UserInfo,personValues,"EMAIL = ?",new String[]{Email});
    }


    public Cursor Getuser(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res= db.rawQuery("SELECT * FROM "+UserInfo+" WHERE EMAIL = '"+email + "'",null );
        return res;
    }
    public Cursor GetPass(String email,String pass)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res= db.rawQuery("SELECT * FROM "+UserInfo+" WHERE EMAIL = '"+ email +"' AND PASSWORD= '" + pass + "'",null );
        return res;
    }

    public Cursor getSummary()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res= db.rawQuery("select  _id , date,bmi,weight from  BMICal  " ,null );
        return res;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createtable () {
        SQLiteDatabase db = this.getWritableDatabase();

    }
}