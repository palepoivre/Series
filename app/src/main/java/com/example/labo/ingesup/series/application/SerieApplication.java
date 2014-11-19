package com.example.labo.ingesup.series.application;

import android.app.Application;

import com.example.labo.ingesup.series.db.DatabaseManager;

/**
 * Created by swater on 19/11/2014.
 */
public class SerieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseManager.getInstance().init(this);
    }
}
