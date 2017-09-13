package com.example.dennis.weatherapp;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dennis on 9/13/17.
 */

public class WeatherService {
    private static final String TAG = Weather.class.getSimpleName() ;
    /*
    *THis is where all our logic wIll get in for the API
     */
    public static void findWeather(String location, Callback callback){
        //Creating a client
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlbuilder = HttpUrl.parse(Constants.OPEN_WEATHER_BASE_URL).newBuilder();
        urlbuilder.addQueryParameter(Constants.OPEN_WEATHER_QUERY_PARAMETER,location);
        urlbuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.OPEN_WEATHER);

        String url = urlbuilder.build().toString();
        Log.v(TAG,"RESULT"+url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
