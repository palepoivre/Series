package com.example.labo.ingesup.series.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Realisateur;
import com.example.labo.ingesup.series.bean.Serie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager _instance;
    private SeriesOpenHelper seriesOpenHelper;

    public static DatabaseManager getInstance() {
        if (_instance == null) {
            _instance = new DatabaseManager();
        }
        return _instance;
    }

    public void init(Context context) {
        if (seriesOpenHelper == null) {
            seriesOpenHelper = new SeriesOpenHelper(context);
        }
    }

    public SeriesOpenHelper getDbHelper() {
        return seriesOpenHelper;
    }

    public List<Genre> getAllGenres() {
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();
        List<Genre> genres = new ArrayList<Genre>();

        Cursor cursor = db.query(SeriesOpenHelper.GenreTable.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Genre genre = new Genre();
            genre.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.GenreTable._ID)));
            genre.setNom(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.GenreTable.COLUMN_NAME)));
            genres.add(genre);
        }

        return genres;
    }

    public List<Serie> getSerieByGenre(int genreId){
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();
        List<Serie> series = new ArrayList<Serie>();

        String whereClause = SeriesOpenHelper.SerieTable.COLUMN_ID_GENRE + " = " + String.valueOf(genreId);

        Cursor cursor = db.query(SeriesOpenHelper.SerieTable.TABLE_NAME, null, whereClause, null, null, null, null);
        while(cursor.moveToNext()){
            Serie serie = new Serie();
            serie.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable._ID)));
            serie.setTitre(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_TITRE)));
            serie.setUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE)));
            serie.setTrailerUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER)));
            serie.setSynopsis(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS)));
            serie.setVue(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_VUE)) > 0);
            serie.setRealisateurs(getRealisateurs(serie.getId()));

            series.add(serie);
        }

        return  series;
    }

    public List<Realisateur> getRealisateurs(int serieId) {
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();
        List<Realisateur> realisateurs = new ArrayList<Realisateur>();

        String whereClause = SeriesOpenHelper.RealisateurTable.COLUMN_ID_SERIE + " = " + String.valueOf(serieId);

        Cursor cursor = db.query(SeriesOpenHelper.RealisateurTable.TABLE_NAME, null, whereClause, null, null, null, null);

        while (cursor.moveToNext()) {
            Realisateur realisateur = new Realisateur();
            realisateur.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.RealisateurTable._ID)));
            realisateur.setNom(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.RealisateurTable.COLUMN_NAME)));

            realisateurs.add(realisateur);
        }

        db.close();

        return realisateurs;
    }

    public Serie getSerie(int serieId){
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();

        String whereClause = SeriesOpenHelper.SerieTable._ID + " = " + String.valueOf(serieId);

        Cursor cursor = db.query(SeriesOpenHelper.SerieTable.TABLE_NAME, null, whereClause, null, null, null, null);

        if(cursor.moveToNext()){
            Serie serie = new Serie();
            serie.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable._ID)));
            serie.setTitre(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_TITRE)));
            serie.setUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE)));
            serie.setTrailerUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER)));
            serie.setSynopsis(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS)));
            serie.setVue(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_VUE)) > 0);
            serie.setRealisateurs(getRealisateurs(serie.getId()));

            return serie;
        }

        return null;
    }

    public long insertGenre(Genre genre) throws SQLException {
    SQLiteDatabase db = seriesOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesOpenHelper.GenreTable.COLUMN_NAME, genre.getNom());
      long newRowId =db.insert(SeriesOpenHelper.GenreTable.TABLE_NAME,null,contentValues);
        if(newRowId==1){
            throw new SQLException("Insertion Failed");
        }
        return newRowId;
    }
    public long insertSerie(SQLiteDatabase db, Serie serie) throws SQLException {

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_TITRE, serie.getTitre());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE, serie.getUrl());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER, serie.getTrailerUrl());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS, serie.getSynopsis());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_VUE, 0);
        long newRowId = db.insert(SeriesOpenHelper.GenreTable.TABLE_NAME,null,contentValues);
        if(newRowId==1){
            throw new SQLException("Insertion Failed");
        }
        return newRowId;
    }

}
