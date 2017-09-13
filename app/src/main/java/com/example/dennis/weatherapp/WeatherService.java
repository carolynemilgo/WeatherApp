package com.example.dennis.weatherapp;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by dennis on 9/13/17.
 */

public class WeatherService {
    /*
    *THis is where all our logic woll get in for the API
    *
     */
    public static void FindWeather(String location, Callback callback){
        //Creating a client
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlbuilder = HttpUrl.parse(Constants.OPEN_WEATHER).newBuilder();
        urlbuilder.addQueryParameter(Constants.OPEN_WEATHER_QUERY_PARAMETER,location);
        String url = urlbuilder.build().toString();

    }
}
