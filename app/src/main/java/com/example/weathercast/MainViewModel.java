package com.example.weathercast;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.weathercast.data.OneDay.entities.Weather1Day;
import com.example.weathercast.data.OneDay.entities.Weather1Entity;
import com.example.weathercast.data.Repository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private Repository repository;
    LiveData<Weather1Entity> weatherData;//list

    public void loadData(Context context, String city){
    this.repository = repository;
        if(weatherData==null){
            repository= new Repository(context);
            weatherData=repository.getWeatherDataDay(city);
            repository.sheduleUpdate();
        }


    }
    public LiveData<Weather1Entity> getWeatherData(){
        return weatherData;
    }


    //public void getDataByCity(String city){
        //weatherData = repository.getWeatherForCity(city);
    //}
}
