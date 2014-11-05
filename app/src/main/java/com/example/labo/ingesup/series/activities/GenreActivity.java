package com.example.labo.ingesup.series.activities;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.list.GenreAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 * Ecran d'acceuil.
 */
public class GenreActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        List<Genre> mesGenres = new ArrayList<Genre>();
        Genre genre1 = new Genre("policier");
        mesGenres.add(genre1);
        Genre genre2 = new Genre("Humour");
        mesGenres.add(genre2);

        ListView listDesGenres = (ListView) findViewById(R.id.lv_genres);
        GenreAdapter monGenreAdapter = new GenreAdapter(this, R.layout.item_genre, mesGenres);
        listDesGenres.setAdapter(monGenreAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.genre, menu);
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