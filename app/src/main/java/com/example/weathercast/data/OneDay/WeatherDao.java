package com.example.weathercast.data.OneDay;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.weathercast.data.OneDay.entities.Weather1Entity;

@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertWeather(Weather1Entity weatherEntity);

    @Update
    public void update(Weather1Entity weatherEntity);

    @Delete
    public void delete(Weather1Entity weatherEntity);

    @Query("SELECT * FROM weather_day ")
    LiveData<Weather1Entity> getWeatherForDay();

}
