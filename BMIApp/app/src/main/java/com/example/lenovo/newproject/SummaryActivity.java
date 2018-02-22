package com.example.lenovo.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.util.Log;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;


public class SummaryActivity extends AppCompatActivity {
    SQLiteDB  BMIDatabase;
    private ListView obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        BMIDatabase = new SQLiteDB(this);

        loadListView ();
    }

    public void loadListView ()
    {
       Cursor cursor = BMIDatabase.getSummary();

       String [] fieldname= new String [] {SQLiteDB.TABLE_COLUMN_ID,SQLiteDB.TABLE_COLUMN_BMI,SQLiteDB.TABLE_COLUMN_DATE,SQLiteDB.TABLE_COLUMN_NAME};
       int [] toview = new int [] {R.id.idtextView,R.id.bmitextView,R.id.datetextView,R.id.weighttextView};
       SimpleCursorAdapter bmiCursorAdapter;
        bmiCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.activity_summary,cursor,fieldname,toview,0  );
        ListView bmiListView = (ListView) findViewById(R.id.bmiListView);
        bmiListView.setAdapter(bmiCursorAdapter);


    }
}
