package com.example.weathercast.data.OneDay.entities;

import java.util.List;

public class Weather1Day {
    private Coord1 coord;

    private List<Weather1> weather;

    private String base;

    private Main1 main;

    private int visibility;

    private Wind1 wind;

    private Clouds1 clouds;

    private int dt;

    private Sys1 sys;

    private int id;

    private String name;

    private int cod;

    public void setCoord(Coord1 coord){
        this.coord = coord;
    }
    public Coord1 getCoord(){
        return this.coord;
    }
    public void setWeather(List<Weather1> weather){
        this.weather = weather;
    }
    public List<Weather1> getWeather(){
        return this.weather;
    }
    public void setBase(String base){
        this.base = base;
    }
    public String getBase(){
        return this.base;
    }
    public void setMain(Main1 main){
        this.main = main;
    }
    public Main1 getMain(){
        return this.main;
    }
    public void setVisibility(int visibility){
        this.visibility = visibility;
    }
    public int getVisibility(){
        return this.visibility;
    }
    public void setWind(Wind1 wind){
        this.wind = wind;
    }
    public Wind1 getWind(){
        return this.wind;
    }
    public void setClouds(Clouds1 clouds){
        this.clouds = clouds;
    }
    public Clouds1 getClouds(){
        return this.clouds;
    }
    public void setDt(int dt){
        this.dt = dt;
    }
    public int getDt(){
        return this.dt;
    }
    public void setSys(Sys1 sys){
        this.sys = sys;
    }
    public Sys1 getSys(){
        return this.sys;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    public int getCod(){
        return this.cod;
    }
}
