package com.example.lenovo.newproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText resultName;
    EditText resultDOB;
    EditText resultHealth;
    EditText resultEmail;
    EditText resultPass;
    SQLiteDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        resultName = (EditText) findViewById(R.id.editText);
        resultDOB = (EditText) findViewById(R.id.editText2);
        resultHealth = (EditText) findViewById(R.id.editText3);
        resultEmail = (EditText) findViewById(R.id.editText8);
        resultPass = (EditText) findViewById(R.id.editText6);


        helper = new SQLiteDB(this);

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

    public void saveUser(View view) {

        helper.Insertuser(resultName.getText().toString(),resultPass.getText().toString(), resultEmail.getText().toString(),
                resultHealth.getText().toString(), resultDOB.getText().toString());
        Toast.makeText(this, "Registered Sucessfully, please login", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("email",resultEmail.getText().toString());
        startActivity(i);
    }
}
