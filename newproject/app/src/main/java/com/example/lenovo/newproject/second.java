package com.example.lenovo.newproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

public class second extends AppCompatActivity {

   private EditText height;
    private EditText Wight;
    double BMI;
   private EditText result;
    SQLiteDB helper;
    private double heightValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Enable baack button to home view
        if (getSupportActionBar() !=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            helper=new SQLiteDB(this);

        }

        //Connecting attributes from design XML to variable
        height = findViewById(R.id.editText8);
        Wight = findViewById(R.id.editText9);
        result=findViewById(R.id.editText4);

}

    protected void calc(View view) {

        double heightValue = Double.parseDouble(height.getText().toString()) / 100;
        double WeightValue = Double.parseDouble(Wight.getText().toString());
        String h=height.getText().toString();
        String w=Wight.getText().toString();
        Double bmi = (WeightValue / (heightValue * heightValue));
        if (heightValue >= 2.5) {
            height.setError("You are taller than Sultan Kösen....Enter correct height");
            height.requestFocus();
        }
        else if(heightValue<=0.5)
        {
            height.setError("Enter correct height");
            height.requestFocus();
        }
        else if(h.isEmpty())
        {
            height.setError("Enter height");
        }
        else if(w.isEmpty())
        {
            Wight.setError("Enter Weight");
        }
        else
        {
            System.out.print("Height is:" + heightValue + " Weight is:" + WeightValue + " BMI value =" + bmi);
            result.setText(Double.toString(bmi));
            displayBMI(bmi);
            helper.InsertBMI(heightValue, WeightValue, bmi);
        }
    }
    public void displayBMI(double bmi)
   {
       String bmiLabel = "";
        if (bmi >= 30) { /* obese */
           bmiLabel = "Your BMI of " + Double.toString(bmi) + " is OBESE.";

        } else if (bmi >= 25) {
            bmiLabel = "Your BMI of " + Double.toString(bmi) + " is OVERWEIGHT.";

       } else if (bmi >= 18.5) {
            bmiLabel= "Your BMI of " + Double.toString(bmi) + " is IDEAL AND HEALTHY.";

        } else {
            bmiLabel= "Your BMI of " + Double.toString(bmi) + " is UNDERWEIGHT.";

        }
       Toast.makeText(getApplicationContext(),bmiLabel.toString(), LENGTH_LONG).show();
   }

    public void list(View view)
    {
        Intent i=new Intent(this,ListAct.class);
        startActivity(i);

    }


}
