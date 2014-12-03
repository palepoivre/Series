package com.example.labo.ingesup.series.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.db.DatabaseManager;
import com.example.labo.ingesup.series.list.GenreAdapter;

/**
 * Ecran d'acceuil.
 */
public class GenreActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        ListView listDesGenres = (ListView) findViewById(R.id.lv_genres);
        GenreAdapter monGenreAdapter = new GenreAdapter(this, R.layout.item_genre, DatabaseManager.getInstance().getAllGenres());
        listDesGenres.setAdapter(monGenreAdapter);

        listDesGenres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Genre clickedGenre = (Genre) parent.getItemAtPosition(position);
                Intent serieActivityIntent = new Intent(GenreActivity.this, SerieActivity.class);
                serieActivityIntent.putExtra(SerieActivity.GENRE_ID, clickedGenre.getId());
                startActivity(serieActivityIntent);

            }
        });
    }
}