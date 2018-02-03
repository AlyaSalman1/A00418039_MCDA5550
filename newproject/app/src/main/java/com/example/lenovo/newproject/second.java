package com.example.lenovo.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class second extends AppCompatActivity {

    EditText height;
    EditText Wight;
    double BMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Enable baack button to home view
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //Connecting attributes from design XML to variable
        height = findViewById(R.id.editText8);
        Wight = findViewById(R.id.editText9);
    }

    public void calc(View view)
    {
        double heightValue = Double.parseDouble(height.getText().toString()) ;
        double WeightValue = Double.parseDouble(Wight.getText().toString()) ;
        BMI=WeightValue/Math.pow(heightValue, 2);
       Toast.makeText(second.this, (int) BMI,Toast.LENGTH_LONG).show();

    }

}
