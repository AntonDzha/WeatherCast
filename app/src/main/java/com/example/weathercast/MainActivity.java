package com.example.weathercast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText CityName = (EditText)findViewById(R.id.editText);
        Button actButton1 = (Button)findViewById(R.id.buttonForDay);
        actButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), ActivityOneDay.class);
                        intent.putExtra("CityName", CityName.getText().toString());
                        startActivity(intent);

                    }
                }
        );
        Button actButton2 = (Button)findViewById(R.id.buttonFor5Days);
        actButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), ActivityFiveDays.class);
                        intent.putExtra("CityName", CityName.getText().toString());
                        startActivity(intent);

                    }
                }
        );
    }
}
