package com.example.weathercast.data.FiveDay.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_5days")
public class Weather5Entity {
    @PrimaryKey
    public Integer key;

    public double temp;

    public String description;
    public String icon;


}
