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
    EditText result;


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
        result=findViewById(R.id.editText4);
    }

    public void calc(View view)
    {
        double heightValue = Double.parseDouble(height.getText().toString()) ;
        double WeightValue = Double.parseDouble(Wight.getText().toString()) ;
        Double bmi = (WeightValue/(heightValue*heightValue));
        System.out.print("Height is:"+heightValue+ " Weight is:"+WeightValue + " BMI value ="+bmi);
        result.setText(Double.toString(bmi));

    }

}
