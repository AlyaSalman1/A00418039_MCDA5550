package com.example.lenovo.newproject;

import java.util.Date;

/**
 * Created by Lenovo on 2/10/2018.
 */

public class BMIResult {
    private double height=1;
    private double weight=1;

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private double bmi=1;
    private String  date;

    public BMIResult(double height, double weight, double bmi, String date){
        this.height=height;
        this.weight=weight;
        this.bmi=bmi;
        this.date=date;
    }
public double getHeight(){return height;}
public void setHeight(double height){this.height=height;}
public double getWeight(){return weight;}
public void setWeight(double weight){this.weight=weight;}
public double getResult(){
    return weight/(height*height);
}
public String toString(){return String.valueOf(getResult());}
}
