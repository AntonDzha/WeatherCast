package com.example.weathercast.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.weathercast.data.FiveDay.Weather5DB;
import com.example.weathercast.data.FiveDay.entities.ForecastDay;
import com.example.weathercast.data.FiveDay.entities.Weather5Day;
import com.example.weathercast.data.FiveDay.entities.Weather5Entity;
import com.example.weathercast.data.OneDay.WeatherDB;
import com.example.weathercast.data.OneDay.entities.Weather1Day;
import com.example.weathercast.data.OneDay.entities.Weather1Entity;

import java.util.ArrayList;
import java.util.List;


public class LocalDataSource {
    final WeatherDB db;
    final Weather5DB db5;
    private MutableLiveData<Weather1Entity> weatherData;

    public LocalDataSource(Context context){
        db= Room.databaseBuilder(context, WeatherDB.class, "weather").build();
        db5= Room.databaseBuilder(context, Weather5DB.class, "weather_5days").build();
    }

    public void storeWeatherForDay(Weather1Day weather){

        //weatherData=new MutableLiveData<>();

        //Weather1Day weather = response.body();
        double temp = weather.getMain().getTemp();
        int key = weather.getWeather().get(0).getId();
        String description = weather.getWeather().get(0).getDescription();
        String icon = weather.getWeather().get(0).getIcon();

        Weather1Entity wthrEnt = new Weather1Entity();
        wthrEnt.key = key;
        wthrEnt.temp = temp;
        wthrEnt.description = description;
        wthrEnt.icon = icon;
        db.weatherDao().insertWeather(wthrEnt);
        //weatherData.postValue(wthrEnt);
    }

    public void storeWeatherFor5Days(Weather5Day weather5){
        List<ForecastDay> lweather = weather5.getList();

        List<Weather5Entity> weatherList = new ArrayList<>();
        for(int i = 0; i < lweather.size(); i++){
            //String formedYear = lweather.get(i).getIntFormedYear();
            double temp = lweather.get(i).getMain().getTemp();
            String icon = lweather.get(i).getWeather().get(0).getIcon();
            String description = lweather.get(i).getWeather().get(0).getDescription();

            int key = i;
            Weather5Entity weather5Entity = new Weather5Entity();
            weather5Entity.key = key;
            weather5Entity.temp = temp;
            weather5Entity.description = description;
            weather5Entity.icon = icon;

            db5.weather5Dao().insertWeather(weather5Entity);
            weatherList.add(weather5Entity);
            //teamData.postValue(teamEntity);
        }
        //teamData.postValue(teamList);
    }

    public LiveData<Weather1Entity> getWeatherforDay(){
        //return null;
        //db.weatherDao().getWeatherForDay();
        return db.weatherDao().getWeatherForDay();
        //return weather1.getValue().get(0);
    }

    public LiveData<List<Weather5Entity>> getWeatherFor5Days(){
        return db5.weather5Dao().getWeatherFor5Days();
    }
}
