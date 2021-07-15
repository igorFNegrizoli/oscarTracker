package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class databaseHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "OscarTrackerDB";
    public static String TABELA_FILME = "filme";
    public static String TABELA_CATEGORIA_FILME = "categoriaFilme";
    public static String TABELA_CATEGORIA = "categoria";


    public databaseHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_create_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_FILME +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " duracao INTEGER NOT NULL, "+
                " descricao TEXT NOT NULL, " +
                " caminhoImagem TEXT NOT NULL," +
                " jaViu INTEGER DEFAULT 0" +
                ");";

        String sql_create_categoria_filme = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA_FILME +"("+
                " id_categoria INTEGER REFERENCES categoria(id),"+
                " id_filme INTEGER REFERENCES filme(id),"+
                " PRIMARY KEY(id_categoria, id_filme),"+
                " rating INTEGER DEFAULT 0," +
                " indicado TEXT"+
                " caminhoImagemIndicado TEXT"+
                ");";

        String sql_create_categoria = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIA +"("+
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " selecionada INTEGER DEFAULT 1"+
                " winner INTEGER REFERENCES filme(id),"+
                " runnerUp INTEGER REFERENCES filme(id),"+
                " wantsToWin INTEGER REFERENCES filme(id),"+
                " actualWinner INTEGER REFERENCES filme(id),"+
                ");";

        try {
            //db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage() );
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //String sql = "DROP TABLE IF EXISTS " + TABELA_PESSOA + " ;" ;

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App" );
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage() );
        }

    }

}
