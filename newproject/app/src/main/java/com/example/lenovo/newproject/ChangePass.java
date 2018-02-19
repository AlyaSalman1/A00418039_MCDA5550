package com.example.lenovo.newproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePass extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText email;
    String passowrd;
    SQLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        //load the passowrd
        db = new SQLiteDB(this);
        email = (EditText) findViewById(R.id.editText7);
        e1 = (EditText) findViewById(R.id.editText5);
        e2 = (EditText) findViewById(R.id.editText10);
    }

    public void change(View view) {

        String text1 = e1.getText().toString();
        String text2 = e2.getText().toString();
        String emailText = email.getText().toString();
        Cursor res = db.Getuser(emailText);
        int length = res.getCount();
        if(length <= 0){
            Toast.makeText(ChangePass.this, "User doesn't Exist", Toast.LENGTH_LONG).show();
        }
        else if (text1.equals(text2)) {
            Toast.makeText(ChangePass.this, "Password match", Toast.LENGTH_LONG).show();
            db.UpdatePass(text1,emailText);
            //Enter the app
            Intent i = new Intent(ChangePass.this, MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(ChangePass.this, "Passowrd doesn't match", Toast.LENGTH_LONG).show();
        }

    }

    public void confirm() {
        String text1 = e1.getText().toString();
        String text2 = e2.getText().toString();
        if (text1.equals(text2)) {
            Intent i = new Intent(ChangePass.this, MainActivity.class);
            //String s=i.getExtras().getString("pass");
            startActivity(i);

        } else {
            Toast.makeText(ChangePass.this, "Passowrd doesn't match", Toast.LENGTH_LONG).show();
        }


    }

}
