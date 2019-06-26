package com.example.weathercast;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.weathercast.data.Repository;

public class SyncWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {
        Repository repository = ((WeatherApp)getApplicationContext()).getRepository();
        return ListenableWorker.Result.success();
    }

    public SyncWorker(Context context, WorkerParameters params){
        super(context,params);
    }
}
