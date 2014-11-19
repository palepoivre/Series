package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;
import com.example.labo.ingesup.series.db.DatabaseManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.sql.DatabaseMetaData;

/**
 * Created by Eliott on 16/10/2014.
 */
public class DetailActivity extends Activity {

    public static final String SERIE_ID = "SERIE_ID";

    /** Eléments graphiques **/
    private TextView mTextViewTitre;
    private TextView mTextViewGenre;
    private TextView mTextViewSynopsis;

    private ImageView mImageViewSerie;
    private ImageView mImageViewYoutube;

    private CheckBox mCheckBoxVue;

    /**/

    /** Objets métiers **/

    Serie mSerieToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //On récupère la série depuis la base de données
        mSerieToDisplay = retrieveSerie();

        //Si on n'a pas réussi a trouver la série a afficher, on s'arrête la
        if(mSerieToDisplay == null)
            return;

        /** On récupère toutes les ressources graphiques **/
        mTextViewTitre = (TextView) findViewById(R.id.tv_detail_titre);
        mTextViewGenre = (TextView) findViewById(R.id.tv_detail_genre);
        mTextViewSynopsis = (TextView) findViewById(R.id.tv_detail_synopsis);

        mImageViewSerie = (ImageView) findViewById(R.id.iv_detail);
        mImageViewYoutube = (ImageView) findViewById(R.id.iv_detail_youtube);

        mCheckBoxVue = (CheckBox) findViewById(R.id.cb_detail_vue);

        //Lorsque l'on clique sur l'image youtube
        mImageViewYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /**/

        //On affiche les informations de la série
        displaySerie();
    }

    private Serie retrieveSerie(){
        //On récupère l'id de la série depuis l'écran précédent
        //int serieId = getIntent().getIntExtra(SERIE_ID, -1);
        int serieId =1;
        if(serieId != -1){
           return DatabaseManager.getInstance().getSerie(serieId);
        }

        return null;
    }

    private void displaySerie(){
        mTextViewTitre.setText(mSerieToDisplay.getTitre());
        mTextViewGenre.setText(mSerieToDisplay.getGenre().getNom());
        mTextViewSynopsis.setText(mSerieToDisplay.getSynopsis());

        ImageLoader.getInstance().displayImage(mSerieToDisplay.getUrl(), mImageViewSerie);

        mCheckBoxVue.setChecked(mSerieToDisplay.isVue());
    }
}
