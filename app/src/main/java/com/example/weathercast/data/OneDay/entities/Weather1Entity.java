package com.example.weathercast.data.OneDay.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//работа с бд
@Entity(tableName = "weather_day")
public class Weather1Entity {
    @PrimaryKey
    public Integer key;

    public double temp;

    public String description;
    public String icon;




}
