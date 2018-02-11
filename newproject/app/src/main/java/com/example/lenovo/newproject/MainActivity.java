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

    EditText resultName;
    EditText resultDOB;
    EditText resultHealth;
    EditText resultEmail;
    EditText resultPass;
    SQLiteDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultName=(EditText)findViewById(R.id.editText);
        resultDOB =(EditText)findViewById(R.id.editText2);
        resultHealth =(EditText)findViewById(R.id.editText3);
        resultEmail =(EditText)findViewById(R.id.editText8);
        resultPass=(EditText)findViewById(R.id.editText6);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        helper=new SQLiteDB(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(SQLiteDB.UserInfo, new String[]
                        {"NAME","EMAIL","PASSWORD","HEALTH_CARD_NUM","DOB"},
                null,null,null,null,null);


        if(cursor.moveToFirst()) {
            String name=cursor.getString(0);
            String pass=cursor.getString(2);
            String health=cursor.getString(3);
            String date=cursor.getString(4);
            String Email=cursor.getColumnName(1);
            resultName.setText(name);
            resultDOB.setText(pass);
            resultHealth.setText(health);
            resultEmail.setText(Email);
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

    public void saveUser(View view)
    {
        helper.Insertuser(resultName.getText().toString(),resultDOB.getText().toString(),resultEmail.getText().toString(),
                resultHealth.getText().toString(),resultDOB.getText().toString());

    }

    public void goToBMI(View view)
    {
        Intent i=new Intent(this,second.class);
        startActivity(i);
    }
}
