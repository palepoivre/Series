package com.example.labo.ingesup.series.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.labo.ingesup.series.bean.Realisateur;
import com.example.labo.ingesup.series.bean.Serie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lepoivre Pierre Antoine on 05/11/2014.
 */
public class SeriesOpenHelper extends SQLiteOpenHelper {

    private  Context mContext;

    private static final String DATABASE_NAME = "series.db";
    private static final int DATABASE_VERSION = 1;     // change whenever anything in the database changes

    public SeriesOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mContext = context;
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SerieTable.TABLE_CREATE);
        db.execSQL(GenreTable.TABLE_CREATE);
        db.execSQL(RealisateurTable.TABLE_CREATE);

        List<Realisateur> listRealisateur = new ArrayList<Realisateur>();
        listRealisateur.add(new Realisateur("D.B. Weiss, David Benioff") );
        try {
            DatabaseManager.getInstance().insertSerie(db, new Serie("Game Of Throne","http://www.nikopik.com/wp-content/uploads/2013/04/game-of-throne.jpg","https://www.youtube.com/watch?v=SVaD8rouJn0", listRealisateur, "Il y a très longtemps, à une époque oubliée, une force a détruit l'équilibre des saisons. Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. La confrérie de la Garde de Nuit, protégeant le Royaume de toute créature pouvant provenir d'au-delà du Mur protecteur, n'a plus les ressources nécessaires pour assurer la sécurité de tous. Après un été de dix années, un hiver rigoureux s'abat sur le Royaume avec la promesse d'un avenir des plus sombres. Pendant ce temps, complots et rivalités se jouent sur le continent pour s'emparer du Trône de Fer, le symbole du pouvoir absolu."));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {}

    public static final class SerieTable {
        public static final String TABLE_NAME = "series";

        public static final String _ID = "_id";
        public static final String COLUMN_TITRE = "titre";
        public static final String COLUMN_URL_IMAGE = "image";
        public static final String COLUMN_URL_TRAILER = "trailer";
        public static final String COLUMN_SYNOPSIS = "synopsis";
        public static final String COLUMN_VUE = "vue";
        public static final String COLUMN_ID_GENRE = "id_genre";


        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + SerieTable._ID + " INTEGER,"
                        + SerieTable.COLUMN_TITRE + " TEXT,"
                        + SerieTable.COLUMN_URL_IMAGE + " TEXT,"
                        + SerieTable.COLUMN_URL_TRAILER + " TEXT,"
                        + SerieTable.COLUMN_SYNOPSIS + " TEXT,"
                        + SerieTable.COLUMN_VUE + " BOOLEAN,"
                        + SerieTable.COLUMN_ID_GENRE + " INTEGER"
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
                        + GenreTable.COLUMN_NAME + " TEXT"
                        + ");";
    }
}
