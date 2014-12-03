package com.example.labo.ingesup.series.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.labo.ingesup.series.bean.Genre;
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

    public List<Serie> getAllSeries() {
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();
        List<Serie> series = new ArrayList<Serie>();

        Cursor cursor = db.query(SeriesOpenHelper.SerieTable.TABLE_NAME, null, null, null, null, null, null);
        while(cursor.moveToNext()){
            Serie serie = new Serie();
            serie.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable._ID)));
            serie.setTitre(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_TITRE)));
            serie.setUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE)));
            serie.setTrailerUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER)));
            serie.setRealisateurs(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUM_REALISATEURS)));
            serie.setSynopsis(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS)));
            serie.setVue(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_VUE)) > 0);

            series.add(serie);
        }

        return series;
    }

    public List<Serie> getSerieByGenre(int genreId) {


        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();
        List<Serie> series = new ArrayList<Serie>();

        String whereClause = null;

        if(genreId !=-1) {
            whereClause = SeriesOpenHelper.SerieTable.COLUMN_ID_GENRE + " = " + String.valueOf(genreId);


        }

        Cursor cursor = db.query(SeriesOpenHelper.SerieTable.TABLE_NAME, null, whereClause, null, null, null, null);
        while (cursor.moveToNext()) {
            Serie serie = new Serie();
            serie.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable._ID)));
            serie.setTitre(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_TITRE)));
            serie.setUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE)));
            serie.setTrailerUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER)));
            serie.setRealisateurs(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUM_REALISATEURS)));
            serie.setSynopsis(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS)));
            serie.setVue(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_VUE)) > 0);

            series.add(serie);
        }
        return series;
}
    public Serie getSerie(int serieId){
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();

        String whereClause = SeriesOpenHelper.SerieTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(serieId) };

        Cursor cursor = db.query(SeriesOpenHelper.SerieTable.TABLE_NAME, null, whereClause, whereConditions, null, null, null);

        if(cursor.moveToNext()){
            Serie serie = new Serie();
            serie.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable._ID)));
            serie.setTitre(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_TITRE)));
            serie.setUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE)));
            serie.setTrailerUrl(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER)));
            serie.setSynopsis(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS)));
            serie.setVue(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_VUE)) > 0);
            serie.setRealisateurs(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUM_REALISATEURS)));
            serie.setGenre(getGenre(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.SerieTable.COLUMN_ID_GENRE))));

            cursor.close();

            return serie;
        }

        return null;
    }

    public Genre getGenre(int genreId){
        SQLiteDatabase db = seriesOpenHelper.getReadableDatabase();

        String whereClause = SeriesOpenHelper.GenreTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(genreId) };

        Cursor cursor = db.query(SeriesOpenHelper.GenreTable.TABLE_NAME, null, whereClause, whereConditions, null, null, null);

        if(cursor.moveToNext()){
            Genre genre = new Genre();
            genre.setId(cursor.getInt(cursor.getColumnIndex(SeriesOpenHelper.GenreTable._ID)));
            genre.setNom(cursor.getString(cursor.getColumnIndex(SeriesOpenHelper.GenreTable.COLUMN_NAME)));

            cursor.close();

            return genre;
        }

        return null;

    }

    public long insertGenre(SQLiteDatabase db, Genre genre) throws SQLException {

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesOpenHelper.GenreTable.COLUMN_NAME, genre.getNom());
        long newRowId = db.insert(SeriesOpenHelper.GenreTable.TABLE_NAME, null, contentValues);

        if(newRowId == -1){
            throw new SQLException("Insertion Failed");
        }

        return newRowId;
    }
    public long insertSerie(SQLiteDatabase db, Serie serie) throws SQLException {

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_TITRE, serie.getTitre());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_URL_IMAGE, serie.getUrl());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_URL_TRAILER, serie.getTrailerUrl());

        String realisateurString = "";
        for(String realisateur : serie.getRealisateurs()){
            realisateurString += realisateur + ";";
        }

        contentValues.put(SeriesOpenHelper.SerieTable.COLUM_REALISATEURS, realisateurString);
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_SYNOPSIS, serie.getSynopsis());
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_VUE, false);
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_ID_GENRE, serie.getGenre().getId());

        long newRowId = db.insert(SeriesOpenHelper.SerieTable.TABLE_NAME, null, contentValues);
        if(newRowId == -1){
            throw new SQLException("Insertion Failed");
        }
        return newRowId;
    }

    public int updateSerie(int serieId) throws SQLException {
        SQLiteDatabase db = seriesOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SeriesOpenHelper.SerieTable.COLUMN_VUE, true);

        String whereClause = SeriesOpenHelper.SerieTable._ID + "=?";
        String[] whereConditions = new String[] { String.valueOf(serieId) };

        int updatedRowId = db.update(SeriesOpenHelper.SerieTable.TABLE_NAME, contentValues, whereClause, whereConditions);

        if(updatedRowId == -1){
            throw new SQLException("Update failed");
        }

        return updatedRowId;
    }

}