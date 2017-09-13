package com.example.dennis.weatherapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Weather extends AppCompatActivity {

    private static final String TAG = Weather.class.getSimpleName() ;
    //Create the binds here
    @Bind(R.id.weatherId)
    TextView locationText;
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
        getWeather(location);
    }
//This is receiver method
    public void getWeather(String location){
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
