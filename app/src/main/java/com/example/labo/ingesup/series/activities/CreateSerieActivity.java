package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.example.labo.ingesup.series.db.DatabaseManager;
import com.example.labo.ingesup.series.list.GenreSpinnerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eliott on 16/10/2014.
 */
public class CreateSerieActivity extends Activity {

    private static final String GOOGLE_IMAGE_URL = "https://www.google.fr/imghp?hl=fr&tab=wi&ei=QgV_VMrGAc_jasrVgNAC&ved=0CAQQqi4oAg";
    private static final String YOUTUBE_URL = "http://www.youtube.com/";

    /** Ressources graphiques **/

    private EditText mEditTextTitre;
    private EditText mEditTextSynopsis;
    private EditText mEditTextRealisateur;
    private EditText mEditTextImage;
    private EditText mEditTextTrailer;

    private Spinner mSpinnerGenre;

    private ImageView mImageViewImage;
    private ImageView mImageViewTrailer;

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
        mEditTextImage = (EditText) findViewById(R.id.et_creation_image);
        mEditTextTrailer = (EditText) findViewById(R.id.et_creation_trailer);

        mSpinnerGenre = (Spinner) findViewById(R.id.s_creation_genre);
        loadSpinnerGenre();

        mImageViewImage = (ImageView) findViewById(R.id.iv_image);
        mImageViewTrailer = (ImageView) findViewById(R.id.iv_trailer);

        mButtonAjouter = (Button) findViewById(R.id.b_creation);

        /**/

        mImageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse(GOOGLE_IMAGE_URL));
                startActivity(intentWeb);
            }
        });

        mImageViewTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL)));
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
                serieACreer.setRealisateurs(retrieveRealisateurs());
                serieACreer.setUrl(mEditTextImage.getText().toString());
                serieACreer.setTrailerUrl(mEditTextTrailer.getText().toString());
                serieACreer.setVue(false);
                serieACreer.setGenre((Genre) mSpinnerGenre.getSelectedItem());

                Exception e = null;
                try {
                    DatabaseManager.getInstance().insertSerie(DatabaseManager.getInstance().getDbHelper().getWritableDatabase(), serieACreer);
                } catch (SQLException exception) {
                    e = exception;
                }

                Toast.makeText(CreateSerieActivity.this, getString((e == null) ? R.string.creation_insert_success : R.string.creation_insert_error), Toast.LENGTH_LONG).show();

                Intent homeIntent = new Intent(CreateSerieActivity.this, SerieActivity.class);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(homeIntent);
            }
        });

    }

    private void loadSpinnerGenre(){
        mSpinnerGenre.setAdapter(new GenreSpinnerAdapter(this, R.layout.item_genre_spinner, DatabaseManager.getInstance().getAllGenres()));
    }

    private List<String> retrieveRealisateurs(){
        List<String> realisateurs = new ArrayList<String>();

        String realisateurInput = mEditTextRealisateur.getText().toString();
        if(realisateurInput != null && !realisateurInput.isEmpty()){
            String[] realisateursTab = realisateurInput.split(",");

            Collections.addAll(realisateurs, realisateursTab);
        }

        return realisateurs;
    }

    /**
     * Retourne vrai si une information est manquante
     */
    private boolean informationIsMissing(){
        boolean a = titreIsMissing();
        boolean b = synopsisIsMissing();
        boolean c = realisateurIsMissing();
        boolean d = genreIsMissing();
        return (titreIsMissing() || synopsisIsMissing() || realisateurIsMissing() || genreIsMissing());
    }

    /**
     * Retourne vrai si le titre n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean titreIsMissing(){
        return (mEditTextTitre.getText() == null || mEditTextTitre.getText().toString().isEmpty());
    }


    /**
     * Retourne vrai si le synopsis n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean synopsisIsMissing(){
        return (mEditTextSynopsis.getText() == null || mEditTextSynopsis.getText().toString().isEmpty());
    }


    /**
     * Retourne vrai si le réalisateur n'a pas été saisi ou qu'il a été saisi mais il est vide
     */
    private boolean realisateurIsMissing(){
        return (mEditTextRealisateur.getText() == null || mEditTextRealisateur.getText().toString().isEmpty());
    }

    /**
     * Retourne vrai si un genre a été sélectionné
     */
    private boolean genreIsMissing(){
        return mSpinnerGenre.getSelectedItem() == null;
    }
}
