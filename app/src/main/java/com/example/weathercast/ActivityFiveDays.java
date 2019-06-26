package com.example.weathercast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weathercast.data.FiveDay.entities.Weather5Entity;
import com.example.weathercast.data.WeatherAdapter;

import java.util.List;

public class ActivityFiveDays extends AppCompatActivity implements Observer<List<Weather5Entity>> {
    TextView cityName;
    LiveData<List<Weather5Entity>> weatherData;
    private WeatherAdapter adapter;
    private RecyclerView recyclerView;
    //private List<TeamEntity>team0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_days);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        String City = getIntent().getStringExtra("CityName");
        cityName = (TextView)findViewById(R.id.cityName);
        cityName.setText(City);

        MainViewModel5Days mainViewModel = ViewModelProviders.of(this).get(MainViewModel5Days.class);
        mainViewModel.loadData(this,City);

        weatherData = mainViewModel.getWeatherData();
        weatherData.observe(this,this);
        Log.i("onStart","Observe" );
        // создаем адаптер
        adapter = new WeatherAdapter(null);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onChanged(List<Weather5Entity> root) {
        Log.i("Root size","" + root.size());
        //for (int i= 0; i < root.size(); i++) {
        //  Log.i("Outcome","" + root.get(i).strStadium);
        //}
        //adapter.changeData(root);
        if /*(root != null)&&*/(!root.isEmpty()) {
            //temper.setText(""+root.temp);
            //Log.e("Omn")


            adapter.changeData(root);
        }
    }
}
