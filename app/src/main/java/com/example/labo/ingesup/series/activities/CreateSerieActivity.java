package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;
import com.example.labo.ingesup.series.list.GenreSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eliott on 16/10/2014.
 */
public class CreateSerieActivity extends Activity {

    /** Ressources graphiques **/

    private EditText mEditTextTitre;
    private EditText mEditTextSynopsis;
    private EditText mEditTextRealisateur;

    private Spinner mSpinnerGenre;

    private ImageView mImageView;

    private Button mButtonAjouter;

    /**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_serie_activity);

        /** Récupération des ressources graphiques **/

        mEditTextTitre = (EditText) findViewById(R.id.et_creation_titre);
        mEditTextSynopsis = (EditText) findViewById(R.id.et_creation_synospsis);
        mEditTextRealisateur = (EditText) findViewById(R.id.et_creation_realisateur);

        mSpinnerGenre = (Spinner) findViewById(R.id.s_creation_genre);
        loadSpinnerGenre();

        mImageView = (ImageView) findViewById(R.id.iv_creation);

        mButtonAjouter = (Button) findViewById(R.id.b_creation);

        /**/

        //Lorsque l'on clique sur l'image
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Lorsque l'on clique sur le bouton
        mButtonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Si toutes les informations ne sont pas saisies
                if(informationIsMissing()) {
                    //J'affiche un message indiquant qu'il manque des informations
                    Toast.makeText(getBaseContext(), getString(R.string.creation_erreur), Toast.LENGTH_LONG).show();
                    return;
                }

                //Dans le cas ou toutes les informations ont été saisies, on crée un nouvel objet Serie
                Serie serieACreer = new Serie();
                serieACreer.setTitre(mEditTextTitre.getText().toString());
                serieACreer.setSynopsis(mEditTextSynopsis.getText().toString());
                serieACreer.setRealisateur(mEditTextRealisateur.getText().toString());
                serieACreer.setVue(false);
                //TODO Ajouter le reste des informations & ajouter à la BDD
            }
        });

    }

    private void loadSpinnerGenre(){
        //TODO Charger les genres depuis la base de données
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("Genre 1"));
        genres.add(new Genre("Genre 2"));
        genres.add(new Genre("Genre 3"));

        mSpinnerGenre.setAdapter(new GenreSpinnerAdapter(this, R.layout.item_genre_spinner, genres));
    }

    /**
     * Retourne vrai si une information est manquante
     */
    private boolean informationIsMissing(){
        return (titreIsMissing() || synopsisIsMissing() || realisateurIsMissing() || genreIsMissing());
    }

    /**
     * Retourne vrai si le titre n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean titreIsMissing(){
        return (mEditTextTitre.getText() != null && !mEditTextTitre.getText().toString().isEmpty());
    }


    /**
     * Retourne vrai si le synopsis n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean synopsisIsMissing(){
        return (mEditTextSynopsis.getText() != null && !mEditTextSynopsis.getText().toString().isEmpty());
    }


    /**
     * Retourne vrai si le réalisateur n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean realisateurIsMissing(){
        return (mEditTextRealisateur.getText() != null && !mEditTextRealisateur.getText().toString().isEmpty());
    }

    /**
     * Retourne vrai si un genre a été sélectionné
     */
    private boolean genreIsMissing(){
        return mSpinnerGenre.getSelectedItem() == null;
    }
}
