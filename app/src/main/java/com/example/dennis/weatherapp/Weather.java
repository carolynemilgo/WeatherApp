package com.example.dennis.weatherapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Weather extends AppCompatActivity {
    public static final String TAG = Weather.class.getSimpleName();
    //Create the binds here
    @Bind(R.id.weatherId) EditText locationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //Place the butterknife here

        ButterKnife.bind(this);

        //Get the intent here
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        locationText.setText(location);
    }
}
