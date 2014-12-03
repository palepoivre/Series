package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labo.ingesup.series.R;

/**
 * Created by swater on 03/12/2014.
 */
public class AccueilActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        final Button genreButton = (Button) findViewById(R.id.b_Listegenres);
        genreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, GenreActivity.class);
                startActivity(intent);
            }
        });

        final Button serieButton = (Button) findViewById(R.id.b_Listeseries);
        serieButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, SerieActivity.class);
                startActivity(intent);
            }
        });
    }
}
