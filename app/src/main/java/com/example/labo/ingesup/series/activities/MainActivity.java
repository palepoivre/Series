package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;
import com.example.labo.ingesup.series.db.DatabaseManager;
import com.example.labo.ingesup.series.db.SeriesOpenHelper;

import java.util.List;

/**
 * Created by Lepoivre Pierre Antoine on 05/11/2014.
 */
public class MainActivity extends Activity {


    private LinearLayout llSeries;
    private LinearLayout llGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeriesOpenHelper a;
        //insertInDatabaseFirstTime();
    }
/*
        // Ici on récupère tous les boutons
        llSeries = (LinearLayout) findViewById(R.id.llSeries);
        llGenres = (LinearLayout) findViewById(R.id.llGenres);

        // La on enregistre le clic sur le bouton (et on définit leur action dans la méthode onClick() en dessous)
        llSeries.setOnClickListener(this);
        llGenres.setOnClickListener(this);

        // BASE DE DONNEES
        // 1. On récupère la liste de tous les series
        List<Serie> allSeries = DatabaseManager.getInstance().getAllSeries();
        // Ici on l'affiche avec une bête boucle for
        Log.d("TAG", "--------------- LISTE DES SERIES ---------------------");
        for(int i=0; i<allSeries.size(); i++) {
            Log.d("TAG", allSeries.get(i).toString());
        }
        // 1. On récupère la liste de tous les series
        List<Genre> allGenres = DatabaseManager.getInstance().getAllSeries();
        // Ici on l'affiche avec une bête boucle for
        Log.d("TAG", "--------------- LISTE DES GENRES ---------------------");
        for(int i=0; i<allGenres.size(); i++) {
            Log.d("TAG", allGenres.get(i).toString());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == llGenres.getId()) {
            startActivity(new Intent(getApplicationContext(), Genre.class));
        }
        else if(arg0.getId() == llSeries.getId()) {
            startActivity(new Intent(getApplicationContext(), Serie.class));
        }
    }*/

}
