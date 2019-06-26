package com.example.weathercast.data.FiveDay;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.weathercast.data.FiveDay.entities.Weather5Entity;

@Database(entities = {Weather5Entity.class},version = 1)
public abstract class Weather5DB extends RoomDatabase {
    public abstract Weather5Dao weather5Dao();
}