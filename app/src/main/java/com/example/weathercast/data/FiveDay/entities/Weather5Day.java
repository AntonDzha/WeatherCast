package com.example.weathercast.data.FiveDay.entities;

import java.util.List;


public class Weather5Day {
    private String cod;

    private double message;

    private int cnt;

    private List<ForecastDay> list;

    private City city;

    public void setCod(String cod){
        this.cod = cod;
    }
    public String getCod(){
        return this.cod;
    }
    public void setMessage(double message){
        this.message = message;
    }
    public double getMessage(){
        return this.message;
    }
    public void setCnt(int cnt){
        this.cnt = cnt;
    }
    public int getCnt(){
        return this.cnt;
    }
    public void setList(List<ForecastDay> list){
        this.list = list;
    }
    public List<ForecastDay> getList(){
        return this.list;
    }
    public void setCity(City city){
        this.city = city;
    }
    public City getCity(){
        return this.city;
    }
}
