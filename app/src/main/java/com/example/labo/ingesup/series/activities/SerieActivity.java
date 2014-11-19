package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.labo.ingesup.series.R;
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

        int genreId = getIntent().getIntExtra(GENRE_ID, -1);
        genreId = 5;

        List<Serie> mesSeries = DatabaseManager.getInstance().getSerieByGenre(genreId);

        ListView listDesSeries = (ListView) findViewById(R.id.lv_serie);

        SerieAdapter serieAdapter = new SerieAdapter(this, R.layout.item_serie, mesSeries);

        listDesSeries.setAdapter(serieAdapter);
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






