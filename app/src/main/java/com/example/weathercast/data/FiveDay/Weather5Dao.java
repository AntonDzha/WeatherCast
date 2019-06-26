package com.example.weathercast.data.FiveDay;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.weathercast.data.FiveDay.entities.Weather5Entity;

import java.util.List;

@Dao
public interface Weather5Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertWeather(Weather5Entity weather5Entity);

    @Update
    public void update(Weather5Entity weather5Entity);

    @Delete
    public void delete(Weather5Entity weather5Entity);

    @Query("SELECT * FROM weather_5days")
    LiveData<List<Weather5Entity>> getWeatherFor5Days();
}
