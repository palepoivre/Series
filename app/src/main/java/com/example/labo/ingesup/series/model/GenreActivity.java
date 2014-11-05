package com.example.labo.ingesup.series.model;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.database.DatabaseManager;

import java.util.List;

/**
 * Ecran d'acceuil.
 */
public class GenreActivity extends Activity {

    private List<GenreActivity> allGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        int cocktailId = getIntent().getIntExtra("idCocktail", 0);

        List<Series> allCocktails = DatabaseManager.getInstance().getAllSeries();
        //recup d'un cocktail diff�rent : ?!
        Cocktail cocktail = null;
        for (int x = 0 ; x <  allCocktails.size() ; x++)
        {
            Cocktail monCocktail;
            monCocktail = allCocktails.get(x);
            if ( cocktailId == monCocktail.getId())
            {
                cocktail = monCocktail;

            }

        }
        //recup de la note
        int CocktailNote = cocktail.getNote();
        noteCocktailRV = (RatingBar)findViewById(R.id.ratingBar1);
        noteCocktailRV.setRating(CocktailNote);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.genre, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Log.d("TAG", "Button clicked !");
        if(v.getId() == lien.getId())
        {
            if(lien)
            {
                lien.setImageResource(android.R.drawable.btn_star_big_on);

            }
        }

    }
}
