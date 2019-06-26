package com.example.weathercast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weathercast.data.OneDay.entities.Weather1Entity;
import com.squareup.picasso.Picasso;

public class ActivityOneDay extends AppCompatActivity implements Observer<Weather1Entity>{
    LiveData<Weather1Entity> weatherData;
    TextView cityName;
    TextView temper;
    ImageView icon;
    TextView description;

    @Override
    public void onChanged(Weather1Entity root) {
        if (root != null) {
            temper.setText(""+root.temp);
            description.setText(""+root.description);
            Picasso.get().load("http://openweathermap.org/img/w/" + root.icon + ".png").resize(50, 50).into(icon);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_day);
        String City = getIntent().getStringExtra("CityName");
        cityName = (TextView)findViewById(R.id.cityName);
        cityName.setText(City);

        temper = (TextView)findViewById(R.id.temper);
        description = (TextView)findViewById(R.id.description);
        icon = (ImageView) findViewById(R.id.wthr_img);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        ((WeatherApp)getApplication()).getRepository();
        mainViewModel.loadData(this,City);
        weatherData = mainViewModel.getWeatherData();
        weatherData.observe(this,this);
    }
}
