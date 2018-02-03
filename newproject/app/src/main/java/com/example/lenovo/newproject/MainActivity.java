package com.example.lenovo.newproject;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SQLiteDB helper=new SQLiteDB(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(SQLiteDB.TABLE_NAME, new String[]
                        {"NAME","PASSWORD","HEALTH_CARD_NUMB","DATE"},
                null,null,null,null,null);
        if(cursor.moveToFirst()) {
            String name=cursor.getString(0);
            String pass=cursor.getString(1);
            String health=cursor.getString(2);
            String date=cursor.getString(3);
            EditText resultName=(EditText)findViewById(R.id.editText);
            resultName.setText(name);
            EditText resultDOB=(EditText)findViewById(R.id.editText2);
            resultDOB.setText(pass);
            EditText resultHealth=(EditText)findViewById(R.id.editText3);
            resultHealth.setText(health);
            EditText resultPass=(EditText)findViewById(R.id.editText6);
            resultPass.setText(date);
        }
        cursor.close();
        db.close();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void click(View view)
    {
        Intent i=new Intent(this,second.class);
        startActivity(i);
    }
}
