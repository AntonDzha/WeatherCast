package com.example.weathercast.data;

import com.example.weathercast.data.FiveDay.entities.Weather5Day;
import com.example.weathercast.data.OneDay.entities.Weather1Day;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("/data/2.5/weather")
    Call<Weather1Day> getWeatherByCityName(@Query("q") String q, @Query("appid") String appid);

    @GET("/data/2.5/forecast")
    Call<Weather5Day> getWeatherByCityForWeek(@Query("q") String city, @Query("appid") String appId);
}
