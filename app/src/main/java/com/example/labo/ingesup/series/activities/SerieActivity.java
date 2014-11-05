package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Serie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clément on 15/10/2014.
 */
public class SerieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        List<Serie> mesSeries = new ArrayList<Serie>();

        Serie serie1 = new Serie();
        serie1.setTitre("The walking dead");
        mesSeries.add(serie1);

        ListView listDesSeries = (ListView) findViewById(R.id.lv_series);

        SerieAdapter serieAdapter = new SerieAdapter(this, R.layout.item_genre, mesSeries);

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






