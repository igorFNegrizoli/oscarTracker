package database;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class databaseHelper extends SQLiteOpenHelper {
    public static int VERSION = 6;
    public static String NOME_DB = "OscarTrackerDB";
    public static String TABELA_FILME = "filme";
    public static String TABELA_CATEGORIA_FILME = "categoriaFilme";
    public static String TABELA_CATEGORIA = "categoria";

    public databaseHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    public void execTableCreation(SQLiteDatabase db, String sql, String table_name){
        try{
            db.execSQL(sql);
            Log.i("INFO BANCODEDADOS", "Sucesso ao criar a tabela "+table_name );
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao criar a tabela "+table_name + e.getMessage() );
        }
    }

    public void instantiate_filme(SQLiteDatabase db, String nome, Integer duracao, String descricao, String caminhoImagem){
        try{
            ContentValues movie_insert = new ContentValues();
            movie_insert.put("nome", nome);
            movie_insert.put("duracao", duracao);
            movie_insert.put("descricao", descricao);
            movie_insert.put("caminhoImagem", caminhoImagem);
            db.insert(TABELA_FILME, null, movie_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filme "+nome+ e.getMessage());
        }
    }

    public void populate_filme(SQLiteDatabase db){
        try{
            instantiate_filme(db,
                    "Minari",
                    115,
                    "A Korean American family moves to an Arkansas farm in " +
                            "search of its own American dream. Amidst the challenges of this new " +
                            "life in the strange and rugged Ozarks, they discover the undeniable " +
                            "resilience of family and what really makes a home.",
                    "image_minari_cover");


            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_FILME);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela filme"+ e.getMessage());
        }
    }

    public void create_filme_table(SQLiteDatabase db){
        String sql_create_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_FILME +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " duracao INTEGER NOT NULL, "+
                " descricao TEXT NOT NULL, " +
                " caminhoImagem TEXT NOT NULL," +
                " jaViu INTEGER DEFAULT 0" +
                ");";

        execTableCreation(db, sql_create_filme, TABELA_FILME);
        populate_filme(db);
    }

    public void instantiate_categoria_filme(SQLiteDatabase db, Integer id_categoria, Integer id_filme, String indicado, String caminhoImagemIndicado){
        try{
            ContentValues movie_category_insert = new ContentValues();
            movie_category_insert.put("id_categoria", id_categoria);
            movie_category_insert.put("id_filme", id_filme);
            movie_category_insert.put("indicado", indicado);
            movie_category_insert.put("caminhoImagemIndicado", caminhoImagemIndicado);
            db.insert(TABELA_CATEGORIA_FILME, null, movie_category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filmeCategoria (" +
                    ""+Integer.toString(id_categoria)+","+Integer.toString(id_filme)+")"+ e.getMessage());
        }
    }

    public void instantiate_categoria_filme(SQLiteDatabase db, Integer id_categoria, Integer id_filme){
        try{
            ContentValues movie_category_insert = new ContentValues();
            movie_category_insert.put("id_categoria", id_categoria);
            movie_category_insert.put("id_filme", id_filme);
            db.insert(TABELA_CATEGORIA_FILME, null, movie_category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar filmeCategoria (" +
                    ""+Integer.toString(id_categoria)+","+Integer.toString(id_filme)+")"+ e.getMessage());
        }
    }

    public void populate_categoria_filme(SQLiteDatabase db){
        try{
            instantiate_categoria_filme(db,1,1, "Steven Yeun", "image_minari_actor");
            instantiate_categoria_filme(db,3,1, "Yuh-Jung Youn", "image_minari_sup_actress");
            instantiate_categoria_filme(db,8,1, "Lee Isaac Chung", "image_minari_direct");
            instantiate_categoria_filme(db,14,1);
            instantiate_categoria_filme(db,16,1);

            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_CATEGORIA_FILME);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela categoriaFilme"+ e.getMessage());
        }
    }

    public void create_categoria_filme_table(SQLiteDatabase db){
        String sql_create_categoria_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA_FILME +"("+
                " id_categoria INTEGER REFERENCES categoria(id),"+
                " id_filme INTEGER REFERENCES filme(id),"+
                " rating INTEGER DEFAULT 0," +
                " indicado TEXT,"+
                " caminhoImagemIndicado TEXT," +
                " CONSTRAINT pk_cat_film PRIMARY KEY (id_categoria, id_filme)"+
                ");";

        execTableCreation(db, sql_create_categoria_filme, TABELA_CATEGORIA_FILME);
        populate_categoria_filme(db);
    }

    public void instantiate_categoria(SQLiteDatabase db, String nome){
        try {
            ContentValues category_insert = new ContentValues();
            category_insert.put("nome", nome);
            db.insert(TABELA_CATEGORIA, null, category_insert);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao instanciar categoria "+nome+ e.getMessage());
        }
    }

    public void populate_categoria(SQLiteDatabase db){
        try{
            instantiate_categoria(db, "Actor in a Leading Role");
            instantiate_categoria(db, "Actor in a Supporting Role");
            instantiate_categoria(db, "Actress in a Leading Role");
            instantiate_categoria(db, "Actress in a Supporting Role");
            instantiate_categoria(db, "Animated Feature Film");
            instantiate_categoria(db, "Cinematography");
            instantiate_categoria(db, "Costume Design");
            instantiate_categoria(db, "Directing");
            instantiate_categoria(db, "Documentary (Feature)");
            instantiate_categoria(db, "Documentary (Short Subject)");
            instantiate_categoria(db, "Film Editing");
            instantiate_categoria(db, "International Feature Film");
            instantiate_categoria(db, "Makeup and Hairstyling");
            instantiate_categoria(db, "Music (Original Score)");
            instantiate_categoria(db, "Music (Original Song)");
            instantiate_categoria(db, "Best Picture");
            instantiate_categoria(db, "Production Design");
            instantiate_categoria(db, "Short Film (Animated)");
            instantiate_categoria(db, "Short Film (Live Action)");
            instantiate_categoria(db, "Sound");
            instantiate_categoria(db, "Visual Effects");
            instantiate_categoria(db, "Writing (Adapted Screenplay)");
            instantiate_categoria(db, "Writing (Original Screenplay)");

            Log.i("INFO BANCODEDADOS", "Sucesso ao popular a tabela "+TABELA_CATEGORIA);
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao popular a tabela categoria"+ e.getMessage());
        }
    }

    public void create_categoria_table(SQLiteDatabase db){
        String sql_create_categoria = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " selecionada INTEGER DEFAULT 1,"+
                " winner INTEGER REFERENCES filme(id),"+
                " runnerUp INTEGER REFERENCES filme(id),"+
                " wantsToWin INTEGER REFERENCES filme(id),"+
                " actualWinner INTEGER REFERENCES filme(id) "+
                ");";

        execTableCreation(db, sql_create_categoria, TABELA_CATEGORIA);
        populate_categoria(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        create_filme_table(db);
        create_categoria_table(db);
        create_categoria_filme_table(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql_create_filme = "DROP TABLE IF EXISTS " + TABELA_FILME + " ;";
        String sql_create_categoria_filme = "DROP TABLE IF EXISTS " + TABELA_CATEGORIA_FILME + " ;";
        String sql_create_categoria = "DROP TABLE IF EXISTS " + TABELA_CATEGORIA + " ;";

        try {
            db.execSQL(sql_create_filme);
            db.execSQL(sql_create_categoria_filme);
            db.execSQL(sql_create_categoria);
            onCreate(db);
            Log.i("INFO BANCODEDADOS", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO BANCODEDADOS", "Erro ao atualizar App" + e.getMessage() );
        }

    }

}
