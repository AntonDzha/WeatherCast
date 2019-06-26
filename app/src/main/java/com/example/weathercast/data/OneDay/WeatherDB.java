package com.example.weathercast.data.OneDay;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.weathercast.data.OneDay.WeatherDao;
import com.example.weathercast.data.OneDay.entities.Weather1Entity;

@Database(entities = {Weather1Entity.class},version = 1)
public abstract class WeatherDB extends RoomDatabase {
    public abstract WeatherDao weatherDao();
}
