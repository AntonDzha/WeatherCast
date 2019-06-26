package com.example.weathercast;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weathercast.data.FiveDay.entities.Weather5Entity;
import com.example.weathercast.data.OneDay.entities.Weather1Entity;
import com.example.weathercast.data.Repository;

import java.util.List;

public class MainViewModel5Days extends ViewModel {
    private Repository repository;
    LiveData<List<Weather5Entity>> weatherData;//list

    public void loadData(Context context, String city){
        this.repository = repository;
        if(weatherData==null){
            repository= new Repository(context);
            weatherData=repository.getWeatherData5Days(city);
            repository.sheduleUpdate();
        }


    }
    public LiveData<List<Weather5Entity>> getWeatherData(){
        return weatherData;
    }
}
