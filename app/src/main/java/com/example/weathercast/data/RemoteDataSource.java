package com.example.weathercast.data;

import android.util.Log;

import com.example.weathercast.data.FiveDay.entities.Weather5Day;
import com.example.weathercast.data.OneDay.entities.Weather1Day;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteDataSource {

    private WeatherService weatherService;

    public RemoteDataSource(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                //.client(client)
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    public Weather1Day getWeatherDay(String city){
        String API_KEY = "6e52e5807b10522b45d6c262e1763198";
        Call<Weather1Day> call=weatherService.getWeatherByCityName(city,API_KEY);
        try {
            Response<Weather1Day> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        }catch(IOException ioex){
                Log.e("Remote",""+ioex);

            //return null;
        }
        return null;
    }

    public Weather5Day getWeather5Days(String city){
        String API_KEY = "6e52e5807b10522b45d6c262e1763198";
        Weather5Day result = null;

        Call<Weather5Day> call = weatherService.getWeatherByCityForWeek(city,API_KEY);

        try {
            Log.e("Remote","1Try: " + call.request().url().toString());
            Response<Weather5Day> response = call.execute();
            if (response.isSuccessful()) {
                Log.e("Remote", "Ok");
                Log.e("Remote", "Resp: " + response.body());
                result = response.body();
            }
            else {
                Log.e("Remote","Fail"+response.code());
            }


            Log.e("Remote","Try");

        }catch(IOException ioex){
            Log.e("Remote",""+ioex);

            //return null
        }
        Log.e("Remote","NeProshlo");
        return result;
    }
}
