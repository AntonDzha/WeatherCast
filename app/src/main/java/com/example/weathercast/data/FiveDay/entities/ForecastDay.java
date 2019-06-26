package com.example.weathercast.data.FiveDay.entities;

import java.util.List;

public class ForecastDay {
    private int dt;

    private Main main;

    private List<Weather> weather;

    private Clouds clouds;

    private Wind wind;

    private Sys sys;

    private String dt_txt;

    public void setDt(int dt){
        this.dt = dt;
    }
    public int getDt(){
        return this.dt;
    }
    public void setMain(Main main){
        this.main = main;
    }
    public Main getMain(){
        return this.main;
    }
    public void setWeather(List<Weather> weather){
        this.weather = weather;
    }
    public List<Weather> getWeather(){
        return this.weather;
    }
    public void setClouds(Clouds clouds){
        this.clouds = clouds;
    }
    public Clouds getClouds(){
        return this.clouds;
    }
    public void setWind(Wind wind){
        this.wind = wind;
    }
    public Wind getWind(){
        return this.wind;
    }
    public void setSys(Sys sys){
        this.sys = sys;
    }
    public Sys getSys(){
        return this.sys;
    }
    public void setDt_txt(String dt_txt){
        this.dt_txt = dt_txt;
    }
    public String getDt_txt(){
        return this.dt_txt;
    }
}
