package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;
import com.example.labo.ingesup.series.db.DatabaseManager;
import com.example.labo.ingesup.series.list.SerieAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clément on 15/10/2014.
 */
public class SerieActivity extends Activity {

    public static final String GENRE_ID = "GENRE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        final int genreId = getIntent().getIntExtra(GENRE_ID, -1);

        List<Serie> mesSeries = DatabaseManager.getInstance().getSerieByGenre(genreId);

        ListView listDesSeries = (ListView) findViewById(R.id.lv_serie);

        Button boutonAjoutSerie = (Button) findViewById(R.id.button_add_serie);
        boutonAjoutSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addActivityIntent = new Intent(SerieActivity.this, CreateSerieActivity.class);
                addActivityIntent.putExtra(CreateSerieActivity.GENRE_ID_AJOUT, genreId);
                startActivity(addActivityIntent);
            }
        });

        final SerieAdapter serieAdapter = new SerieAdapter(this, R.layout.item_serie, mesSeries);

        listDesSeries.setAdapter(serieAdapter);

        listDesSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Serie clickedSerie = (Serie) parent.getItemAtPosition(position);

                Intent detailActivityIntent = new Intent(SerieActivity.this, DetailActivity.class);
                detailActivityIntent.putExtra(DetailActivity.SERIE_ID, clickedSerie.getId());
                startActivity(detailActivityIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.series, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}






