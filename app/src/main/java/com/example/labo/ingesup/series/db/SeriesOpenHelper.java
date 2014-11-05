package com.example.labo.ingesup.series.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by swater on 05/11/2014.
 */
public class SeriesOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "series.db";
    private static final int DATABASE_VERSION = 1;     // change whenever anything in the database changes

    public SeriesOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SeriesTable.TABLE_CREATE);
        db.execSQL(GenreTable.TABLE_CREATE);
        db.execSQL(RealisateurTable.TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {}

    public static final class SeriesTable {
        public static final String TABLE_NAME = "series";

        public static final String _ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_URL_IMAGE = "image";
        public static final String COLUMN_URL_TRAILER = "trailer";
        public static final String COLUMN_SYNOPSIS = "synopsis";
        public static final String COLUMN_VUE = "vue";
        public static final String COLUMN_ID_GENRE = "id_genre";


        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + SeriesTable._ID + " INTEGER,"
                        + SeriesTable.COLUMN_NAME + " TEXT,"
                        + SeriesTable.COLUMN_URL_IMAGE + " TEXT,"
                        + SeriesTable.COLUMN_URL_TRAILER + " TEXT,"
                        + SeriesTable.COLUMN_SYNOPSIS + " TEXT,"
                        + SeriesTable.COLUMN_VUE + " BOOLEAN,"
                        + SeriesTable.COLUMN_ID_GENRE + " INTEGER"
                        + ");";
    }

    public static final class RealisateurTable {
        public static final String TABLE_NAME = "realisateur";

        public static final String _ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ID_SERIE = "id_serie";

        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + RealisateurTable._ID + " INTEGER,"
                        + RealisateurTable.COLUMN_NAME + " TEXT,"
                        + RealisateurTable.COLUMN_ID_SERIE + " INTEGER"
                        + ");";
    }

    public static final class GenreTable {
        public static final String TABLE_NAME = "genre";

        public static final String _ID = "_id";
        public static final String COLUMN_NAME = "name";

        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + GenreTable._ID + " INTEGER,"
                        + GenreTable.COLUMN_NAME + " TEXT,"
                        + ");";
    }
}
