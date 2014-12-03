package com.example.labo.ingesup.series.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.labo.ingesup.series.bean.Genre;
import com.example.labo.ingesup.series.bean.Serie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lepoivre Pierre Antoine on 05/11/2014.
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
        db.execSQL(SerieTable.TABLE_CREATE);
        db.execSQL(GenreTable.TABLE_CREATE);

        insertGenres(db);
        insertSeries(db);
    }

    private void insertGenres(SQLiteDatabase db){
        List<Genre> genresToInsert = new ArrayList<Genre>();
        genresToInsert.add(new Genre("Policier"));
        genresToInsert.add(new Genre("Humour"));
        genresToInsert.add(new Genre("Action"));
        genresToInsert.add(new Genre("Aventure"));
        genresToInsert.add(new Genre("Dramatique"));
        genresToInsert.add(new Genre("Espionnage"));
        genresToInsert.add(new Genre("Guerre"));
        genresToInsert.add(new Genre("Fantastique"));
        genresToInsert.add(new Genre("Medicale"));
        genresToInsert.add(new Genre("Science fiction"));
        genresToInsert.add(new Genre("Triller"));

        for(Genre genreToInsert : genresToInsert){
            try {
                DatabaseManager.getInstance().insertGenre(db, genreToInsert);
            } catch (SQLException ignored) {}
        }
    }

    private void insertSeries(SQLiteDatabase db){
        List<Serie> seriesToInsert = new ArrayList<Serie>();
        seriesToInsert.add(new Serie("Game Of Throne","http://www.nikopik.com/wp-content/uploads/2013/04/game-of-throne.jpg","SVaD8rouJn0", new ArrayList<String>() {{ add("D.B. Weiss"); add("David Benioff"); }} , "Il y a très longtemps, à une époque oubliée, une force a détruit l'équilibre des saisons. Dans un pays où l'été peut durer plusieurs années et l'hiver toute une vie, des forces sinistres et surnaturelles se pressent aux portes du Royaume des Sept Couronnes. La confrérie de la Garde de Nuit, protégeant le Royaume de toute créature pouvant provenir d'au-delà du Mur protecteur, n'a plus les ressources nécessaires pour assurer la sécurité de tous. Après un été de dix années, un hiver rigoureux s'abat sur le Royaume avec la promesse d'un avenir des plus sombres. Pendant ce temps, complots et rivalités se jouent sur le continent pour s'emparer du Trône de Fer, le symbole du pouvoir absolu.", new Genre(4)));
        seriesToInsert.add(new Serie("Breakind bad","http://images.amcnetworks.com/amctv.com/wp-content/uploads/2014/04/BB-explore-S4-980x551-clean.jpg","HhesaQXLuRY", new ArrayList<String>() {{ add("Vince Gilligan"); }} , "Walter White, 50 ans, est professeur de chimie dans un lycée du Nouveau-Mexique. Pour subvenir aux besoins de Skyler, sa femme enceinte, et de Walt Junior, son fils handicapé, il est obligé de travailler doublement. Son quotidien déjà morose devient carrément noir lorsqu'il apprend qu'il est atteint d'un incurable cancer des poumons. Les médecins ne lui donnent pas plus de deux ans à vivre. Pour réunir rapidement beaucoup d'argent afin de mettre sa famille à l'abri, Walter ne voit plus qu'une solution : mettre ses connaissances en chimie à profit pour fabriquer et vendre du crystal meth, une drogue de synthèse qui rapporte beaucoup. Il propose à Jesse, un de ses anciens élèves devenu un petit dealer de seconde zone, de faire équipe avec lui. Le duo improvisé met en place un labo itinérant dans un vieux camping-car. Cette association inattendue va les entraîner dans une série de péripéties tant comiques que pathétiques.", new Genre(5)));
        seriesToInsert.add(new Serie("NCIS","http://img1.gtsstatic.com/wallpapers/159bee9366d6ce3eb0a0bd1a3784128f_large.jpeg","BhtDgn31XZo", new ArrayList<String>() {{ add("Donald P. Bellisario"); }} , "La Naval Criminal Investigative Service regroupe une équipe d'agents spéciaux chargés d'enquêter sur des crimes concernant la Marine.", new Genre(1)));
        seriesToInsert.add(new Serie("How I Met Your Mother","http://img0.gtsstatic.com/wallpapers/ccd7fb98bf48d33a6896b3b3225ee7a2_large.jpeg","apRiP2h-O5o", new ArrayList<String>() {{ add("Carter Bays");add("Craig Thomas"); }} , "Ted se remémore ses jeunes années, lorsqu'il était encore célibataire. Il raconte à ses enfants avec nostalgie ses moments d'égarements et de troubles, ses rencontres et ses recherches effrénées du Grand Amour et les facéties de sa bande d'amis...", new Genre(2)));
        seriesToInsert.add(new Serie("Supernatural","http://i.ytimg.com/vi/tjej1TN7be4/maxresdefault.jpg","4kmA86_hnbo", new ArrayList<String>() {{ add("McG"); }} , "Deux frères parcourent les Etats-Unis pour traquer les forces du Mal. Ils espèrent par la même occasion mettre la main sur le démon responsable de la mort de leur mère, vingt ans plus tôt.", new Genre(8)));
        seriesToInsert.add(new Serie("Grey's Anatomy","http://images1.fanpop.com/images/photos/1400000/Grey-s-Anatomy-greys-anatomy-1450907-1280-1024.jpg","baRfki0-L2Q", new ArrayList<String>() {{ add("Shonda Rhimes"); }} , "Meredith Grey, fille d'un chirurgien très réputé, commence son internat de première année en médecine chirurgicale dans un hôpital de Seattle. La jeune femme s'efforce de maintenir de bonnes relations avec ses camarades internes, mais dans ce métier difficile la compétition fait rage...", new Genre(9)));
        seriesToInsert.add(new Serie("Under The Dome","http://upload.wikimedia.org/wikipedia/en/0/01/Under_the_Dome_intertitle.jpg","f_Y5YeYrqUk", new ArrayList<String>() {{  add("Brian K. Vaughan"); }} , "Les habitants d’une petite communauté se réveillent un matin, coupés du monde et piégés dans la ville à cause d’un immense dôme transparent. Certains tenteront, de manière dissimulée, de tirer profit de cette situation inquiétante et inexpliquée, afin de prendre le pouvoir. Mais une résistance va s’organiser autour d'un vétéran de la guerre en Irak, pour empêcher ces personnes malveillantes de parvenir à leur fin.", new Genre(10)));
        seriesToInsert.add(new Serie("Spartacus ","http://img1.wikia.nocookie.net/__cb20130525160711/spartacus/fr/images/a/a4/Saison_1_Promo_2.jpg","4WXDJPaHuR4", new ArrayList<String>() {{  add("Steven S. DeKnight"); }} , "C’est dans le sang et le sable des arènes que s’écrit la légende de Spartacus. Puissant guerrier Thrace trahi par un ambitieux légat romain, Spartacus est réduit en esclavage, contraint de devenir gladiateur s’il veut un jour revoir sa femme. Au sein de l’école de gladiateurs du machiavélique Batiatus et de son épouse Lucretia, Spartacus recevra l’enseignement de l’impitoyable Doctore pour devenir le plus redoutable des combattants. Mais entre l’hostilité des autres gladiateurs et les manigances de Lucretia, Spartacus devra tout sacrifier pour pouvoir survivre...", new Genre(7)));
        seriesToInsert.add(new Serie("Marvel : Les Agents du SHIELD","http://i7.imgiz.com/rshots/7914/marvels-agents-of-shield-2-sezon-8-bolum-fragmani_7914510-5537_1200x630.jpg","T3T-evQZiQo", new ArrayList<String>() {{  add("Joss Whedon"); add("Jed Whedon"); add("Maurissa Tancharoen"); }} , "Les aventures mouvementées des membres de la Strategic Homeland Intervention, Enforcement and Logistics Division, plus connu sous le nom de S.H.I.E.L.D.", new Genre(6)));
        seriesToInsert.add(new Serie("The Original","https://bookstvme.files.wordpress.com/2014/05/421260-the-originals-the-originals-logo.jpg","hkda88RFTdc", new ArrayList<String>() {{  add("Julie Plec"); }} , "Niklaus Mikaelson retourne à la Nouvelle-Orléans pour détrôner l'un de ses anciens protégés, Marcel, qui règne sur la ville en son absence, la ville qu'il a créée. Quand il reviendra, il verra que beaucoup de choses ont changé, comme le fait que les sorcières n'aient plus le droit de pratiquer de la magie, que les loups-garous ont été exclus de la ville et que les vampires règnent à présent. Alors qu'il était surpris de voir que Marcel, son ancien protégé est toujours en vie alors qu'il le pensait mort lors de l'incendie en 1920 qui a brulé la ville entière, il découvrira également qu'il va devenir père. Après de longs moments d'hésitations, il décidera de garder le bébé qui est également l'enfant de Hayley Marshall, une loup-garou avec qui Klaus avait eu une aventure.", new Genre(8)));
        seriesToInsert.add(new Serie("Person Of Interest ","http://pulpcluub.files.wordpress.com/2013/03/person-of-interest-04.jpg","SVaD8rouJn0", new ArrayList<String>() {{  add("Jonathan Nolan"); }} , "Un agent paramilitaire de la CIA, présumé mort, est recruté par un millionnaire reclu pour travailler sur un projet top-secret : prévenir le crime avant qu'il ne se produise ! Un ingénieux programme élaboré par Finch identifie chaque jour des personnes qui vont être impliquées dans un crime. Victime ou coupable ? Reese va devoir mener l'enquête pour découvrir qui est en danger et empêcher qu'un nouveau meurtre soit commis...", new Genre(3)));
        seriesToInsert.add(new Serie("The Walking Dead ","http://www.circlecinema.com/wp-content/uploads/2013/03/the-walking-dead-poster.jpg","R1v0uFms68U", new ArrayList<String>() {{  add("Frank Darabont"); }} , "Après une apocalypse ayant transformé la quasi-totalité de la population en zombies, un groupe d'hommes et de femmes mené par l'officier Rick Grimes tente de survivre...", new Genre(5)));
        seriesToInsert.add(new Serie("Dexter ","http://spoileralertv.files.wordpress.com/2011/11/dexter-6-avenging-angel-poster.jpg","R6_qsTCBns8", new ArrayList<String>() {{  add("James Manos Jr"); }} , "Brillant expert scientifique du service médico-légal de la police de Miami, Dexter Morgan est spécialisé dans l'analyse de prélèvements sanguins. Mais voilà, Dexter cache un terrible secret : il est également tueur en série. Un serial killer pas comme les autres, avec sa propre vision de la justice.", new Genre(11)));
        seriesToInsert.add(new Serie("Sherlock ","http://streamingworld.org/wp-content/uploads/2014/08/sherlock.jpg","iJzuVCw78Ek", new ArrayList<String>() {{  add("Steven Moffat"); add("Mark Gatiss"); }} , "Les aventures de Sherlock Holmes et de son acolyte de toujours, le docteur Watson, sont transposées au XXIème siècle...", new Genre(11)));
        seriesToInsert.add(new Serie("House of Cards","http://4.bp.blogspot.com/-GnSIZTE3cGk/UwatJCrYhUI/AAAAAAAACoY/hwHgSalyVbg/s1600/ibo_et_non_redibo_house_of_cards_1.JPG","ULwUzF1q5w4", new ArrayList<String>() {{  add("Beau Willimon"); }} , "Frank Underwood, homme politique rusé et vieux briscard de Washington, est prêt à tout pour conquérir le poste suprême... ", new Genre(10)));
        seriesToInsert.add(new Serie("Arrow","https://entarteurdeculture.files.wordpress.com/2014/01/3532878-arrow.jpg","ViFb0paKdgg", new ArrayList<String>() {{  add("Andrew Kreisberg"); }} , "Les nouvelles aventures de Green Arrow/Oliver Queen, combattant ultra efficace issu de l'univers de DC Comics et surtout archer au talent fou, qui appartient notamment à la Justice League. Disparu en mer avec son père et sa petite amie, il est retrouvé vivant 5 ans plus tard sur une île près des côtes Chinoises. Mais il a changé : il est fort, courageux et déterminé à débarrasser Starling City de ses malfrats...", new Genre(3)));
        for(Serie serieToInsert : seriesToInsert){
            try {
                DatabaseManager.getInstance().insertSerie(db, serieToInsert);
            } catch (SQLException ignored) {}
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
        public static final String COLUM_REALISATEURS = "realisateurs";
        public static final String COLUMN_VUE = "vue";
        public static final String COLUMN_ID_GENRE = "id_genre";


        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + SerieTable._ID + " INTEGER PRIMARY KEY,"
                        + SerieTable.COLUMN_TITRE + " TEXT,"
                        + SerieTable.COLUMN_URL_IMAGE + " TEXT,"
                        + SerieTable.COLUMN_URL_TRAILER + " TEXT,"
                        + SerieTable.COLUM_REALISATEURS + " TEXT, "
                        + SerieTable.COLUMN_SYNOPSIS + " TEXT,"
                        + SerieTable.COLUMN_VUE + " BOOLEAN,"
                        + SerieTable.COLUMN_ID_GENRE + " INTEGER"
                        + ");";
    }

    public static final class GenreTable {
        public static final String TABLE_NAME = "genre";

        public static final String _ID = "_id";
        public static final String COLUMN_NAME = "name";

        public static final String TABLE_CREATE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + GenreTable._ID + " INTEGER PRIMARY KEY,"
                        + GenreTable.COLUMN_NAME + " TEXT"
                        + ");";
    }
}
