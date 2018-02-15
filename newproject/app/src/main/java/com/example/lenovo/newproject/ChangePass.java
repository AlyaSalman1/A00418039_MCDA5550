package com.example.lenovo.newproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePass extends AppCompatActivity {
    EditText e1;
    EditText e2;
    String passowrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        //load the passowrd
        SharedPreferences set=getSharedPreferences("PREFS",0);
        passowrd=set.getString("password","");
        Handler handeler=new Handler();
        EditText e1 = (EditText) findViewById(R.id.editText5);
        EditText e2 = (EditText) findViewById(R.id.editText10);
    }

    public void change() {

        String text1 = e1.getText().toString();
        if (text1.equals(passowrd))
        {
            Toast.makeText(ChangePass.this, "Passowrd match", Toast.LENGTH_LONG).show();
            Toast.makeText(ChangePass.this, "Enter new pass", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(ChangePass.this, "Passowrd doesn't match", Toast.LENGTH_LONG).show();
        }

    }
    public void confirm() {
        String text1 = e1.getText().toString();
        if (text1.equals(passowrd)){
        //Enter the App
        Intent i=new Intent(ChangePass.this,MainActivity.class);
        startActivity(i);
        finish();

    }
    else
        {
            Toast.makeText(ChangePass.this, "Passowrd doesn't match", Toast.LENGTH_LONG).show();
        }


    }

}
