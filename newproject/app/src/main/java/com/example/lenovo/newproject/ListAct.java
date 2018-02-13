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

public class ListAct extends ListActivity {
    //Create dummy data until database is ready
   ArrayList<BMIResult> results= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //add to oncreate
        ListView listBMIResults=getListView();

        SQLiteDB helper= new SQLiteDB(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(SQLiteDB.UserInfo, new String[]
                        {"HEIGHT","WEIGHT","BMI","DATE"},
                null,null,null,null,null);

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

        }
        cursor.close();
        db.close();

        ArrayAdapter<BMIResult>listAdapter=new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,
                results);
        listBMIResults.setAdapter(listAdapter);

    }


    public void onListItemClick(ListView listView,
                View itemView,
                                int position,
                                long id){

        Toast.makeText(getApplicationContext(), "clicked on"+results.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
