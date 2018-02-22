package com.example.lenovo.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MultiColAddapter extends ArrayAdapter<BMIResult>{
    private LayoutInflater mInflater;
    private ArrayList<BMIResult> results;
    private int mViewResourceId;

    public MultiColAddapter(Context context, int textViewResourceId, ArrayList<BMIResult> users) {
        super(context, textViewResourceId, users);
        this.results=results;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        BMIResult res = results.get(position);

        if (res != null) {
            TextView H = (TextView) convertView.findViewById(R.id.textView10);
            TextView W = (TextView) convertView.findViewById(R.id.textView10);
            TextView BMI = (TextView) convertView.findViewById(R.id.textView11);
            TextView Date = (TextView) convertView.findViewById(R.id.textView12);
            if (H != null) {
                double SH = Double.parseDouble(String.valueOf(res.getHeight()));
                H.setText(SH + "\n");
            }
            if(W!=null) {
                String SW = Double.parseDouble(String.valueOf(res.getWeight());
                W.setText(SW + "\n");
            }
            if(BMI!=null) {
                String SBMI= String.valueOf(res.getBmi());
                BMI.setText(SBMI + "\n");
            }
            if(Date!=null) {
                String SDate= String.valueOf(res.getDate());
                Date.setText(SDate + "\n");
            }


        }

        return convertView;
    }
}
