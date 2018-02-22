package com.example.lenovo.newproject;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class ListAct extends  AppCompatActivity {



   ArrayList<BMIResult> results= new ArrayList<>();
    ListView listView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //add to oncreate
     // ListView listBMIResults=getListView();


        SQLiteDB helper= new SQLiteDB(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(SQLiteDB.BMICal, new String[]
                        {"HEIGHT","WEIGHT","BMI","DATE"},
                null,null,null,null,null);

        //results.clear();


        try{
            while (cursor.moveToNext()){
                String date = cursor.getString(3);
                String BMI = cursor.getString(2);
                String WEIGHT = cursor.getString(1);
                String HEIGHT = cursor.getString(0);
                results.add(new BMIResult(Double.parseDouble(HEIGHT), Double.parseDouble(WEIGHT), Double.parseDouble(BMI), date));

            }
        }
        finally {
Toast
        }
        cursor.close();
        db.close();

        MultiColAddapter adapter =  new MultiColAddapter(this,R.layout.listlayout, results);
    listView1 = (ListView) findViewById(R.id.list);
        listView1.setAdapter(adapter);

    }
    //    ArrayAdapter<BMIResult>listAdapter=new ArrayAdapter<BMIResult>(
      //          this,
        //        android.R.layout.simple_list_item_1,
          //      results);
        //listBMIResults.setAdapter(listAdapter);

    //}


    public void onListItemClick(ListView listView,
                View itemView,
                                int position,
                                long id){

        Toast.makeText(getApplicationContext(), "clicked on"+results.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
