package com.example.sachingupta.test3;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnSelectDuScreen extends Activity implements
        OnItemSelectedListener{
    Spinner s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent=getIntent();
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s3=(Spinner)findViewById(R.id.spinner3);

        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);
        s3.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View view, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        s1.getSelectedItem().toString();
        if  (arg0 == s1)
        {
            DatabaseHelper myDbHelper = new DatabaseHelper(this);
            try {
                myDbHelper.createDataBase();
            } catch (IOException ioe) {
                throw new Error("Unable to create database");
            }
            try {
                myDbHelper.openDataBase();
            } catch (SQLException sqle) {
                throw sqle;
            }

            List<String> quotes = myDbHelper.getQuotes(s1.getSelectedItem().toString());
            myDbHelper.close();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter.notifyDataSetChanged();
            s2.setAdapter(adapter);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}