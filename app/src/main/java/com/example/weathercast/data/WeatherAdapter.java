package com.example.weathercast.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weathercast.R;
import com.example.weathercast.data.FiveDay.entities.Weather5Entity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherHolder>{
    List<Weather5Entity> data;
    public WeatherAdapter(List<Weather5Entity> data){
        this.data=data;
    }

    public void changeData(List<Weather5Entity> data){
        this.data = data;
        notifyDataSetChanged();
    }

    class WeatherHolder extends RecyclerView.ViewHolder{

        private TextView temper;
        private TextView description;
        private ImageView icon;

        public WeatherHolder(View view){
            super(view);
            temper = view.findViewById(R.id.temper);
            description = view.findViewById(R.id.description);
            icon = view.findViewById(R.id.wthr_img);


        }
        public void setData(String info){
            temper.setText(info);
            description.setText(info);
            //descr.setText(info);
        }
    }

    @NonNull
    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_item,viewGroup,false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherHolder holder, int i) {

        holder.temper.setText(""+data.get(i).temp);
        holder.description.setText(""+data.get(i).description);
        Picasso.get().load("http://openweathermap.org/img/w/" + data.get(i).icon + ".png").into(holder.icon);

    }

    @Override
    public int getItemCount() {
        if(data!=null) {
            return data.size();
        } else {
            return 0;
        }
    }
}
