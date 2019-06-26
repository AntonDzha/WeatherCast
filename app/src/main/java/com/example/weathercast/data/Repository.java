package com.example.weathercast.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;


import com.example.weathercast.SyncWorker;
import com.example.weathercast.data.FiveDay.entities.Weather5Entity;
import com.example.weathercast.data.OneDay.entities.Weather1Entity;

import java.util.List;
import java.util.concurrent.Executors;

public class Repository {
    private LocalDataSource localDataSource;
    private RemoteDataSource remoteDataSource;
    public Repository (Context context){
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }
    public LiveData<Weather1Entity> getWeatherDataDay(final String city){

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                 localDataSource.storeWeatherForDay(remoteDataSource.getWeatherDay(city));
            }
        } );
        return localDataSource.getWeatherforDay();
    }
    public LiveData<List<Weather5Entity>> getWeatherData5Days(final String city){

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                localDataSource.storeWeatherFor5Days(remoteDataSource.getWeather5Days(city));
            }
        } );
        return localDataSource.getWeatherFor5Days();
    }

    public void sheduleUpdate() {
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(SyncWorker.class).build();
        WorkManager.getInstance().enqueue(request);
//        WorkManager.getInstance().getWorkInfoByIdLiveData(); // чтобы следить за статусом нашей задачи
    }

}
