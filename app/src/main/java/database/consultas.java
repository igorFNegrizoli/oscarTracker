package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.Pair;
import android.view.Display;

import com.example.oscartracker.movie.ModelMovieNomination;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.ArrayList;
import java.util.List;

public class consultas {
    public void consultaTodosFilmes(SQLiteDatabase le){
        try{
            String consulta = "SELECT * FROM filme ORDER BY nome";
            Cursor cursor = le.rawQuery(consulta,null);

            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceDuracao = cursor.getColumnIndex("duracao");
            int indiceDescricao = cursor.getColumnIndex("descricao");
            int indiceCaminhoImagem = cursor.getColumnIndex("caminhoImagem");
            int indiceJaViu = cursor.getColumnIndex("jaViu");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                String id = cursor.getString(indiceID);
                String nome = cursor.getString(indiceNome);
                String duracao = cursor.getString(indiceDuracao);
                String descricao = cursor.getString(indiceDescricao);
                String caminhoImagem = cursor.getString(indiceCaminhoImagem);
                String jaViu = cursor.getString(indiceJaViu);

                Log.i("RESULTADO - ","ID: "+id+" Nome: "+nome
                );

                Log.i("RESULTADO - ","ID: "+id+" Nome: "+nome+" Duracao: "+duracao+"\n  Descricao: "+descricao+"\n" +
                        " Imagem: "+caminhoImagem+" JaViu: "+jaViu
                );

                cursor.moveToNext();
            }

            cursor.close();

        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO");
            e.printStackTrace();
        }
    }

    public void consultaTodosCategorias(SQLiteDatabase le){
        try{
            String consulta = "SELECT * FROM categoria";
            Cursor cursor = le.rawQuery(consulta,null);

            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceSelecionada = cursor.getColumnIndex("selecionada");
            int indiceWinner = cursor.getColumnIndex("winner");
            int indiceRunnerUp = cursor.getColumnIndex("runnerUp");
            int indiceWantsToWin = cursor.getColumnIndex("wantsToWin");
            int indiceActualWinner = cursor.getColumnIndex("actualWinner");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                String id = cursor.getString(indiceID);
                String nome = cursor.getString(indiceNome);
                String selecionada = cursor.getString(indiceSelecionada);
                String winner = cursor.getString(indiceWinner);
                String runnerUp = cursor.getString(indiceRunnerUp);
                String wantsToWin = cursor.getString(indiceWantsToWin);
                String actualWinner = cursor.getString(indiceActualWinner);

                Log.i("RESULTADO - ","ID: "+id+" Nome: "+nome+" Selecionada: "+selecionada+"  Winner: "+winner+"" +
                        " RunnerUp: "+runnerUp+" Wants to Win: "+wantsToWin+" Actual: "+actualWinner
                );

                cursor.moveToNext();
            }

            cursor.close();

        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO");
            e.printStackTrace();
        }
    }

    public void consultaTodosFilmeCategorias(SQLiteDatabase le){
        try{
            String consulta = "SELECT * FROM categoriaFilme";
            Cursor cursor = le.rawQuery(consulta,null);

            int indiceIdCategoria = cursor.getColumnIndex("id_categoria");
            int indiceIdFilme = cursor.getColumnIndex("id_filme");
            int indiceRating = cursor.getColumnIndex("rating");
            int indiceIndicado = cursor.getColumnIndex("indicado");
            int indiceCaminhoImagemIndicado = cursor.getColumnIndex("caminhoImagemIndicado");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                String id_categoria = cursor.getString(indiceIdCategoria);
                String id_filme = cursor.getString(indiceIdFilme);
                String rating = cursor.getString(indiceRating);
                String indicado = cursor.getString(indiceIndicado);
                String caminhoImagemIndicado = cursor.getString(indiceCaminhoImagemIndicado);

                Log.i("RESULTADO - ","ID Categoria: "+id_categoria+" ID Filme: "+id_filme+" Rating: "+rating+"  Indicado: "+indicado+"" +
                        " Caminho Imagem: "+caminhoImagemIndicado
                );

                cursor.moveToNext();
            }

            cursor.close();

        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO");
            e.printStackTrace();
        }
    }

    public List<ModelMoviesList> consultaMoviesList(SQLiteDatabase le){
        List<ModelMoviesList> listMovies = new ArrayList<>();

        try{
            String consulta = "SELECT filme.nome, duracao, COUNT(DISTINCT id_categoria) AS Nomeacoes, jaViu " +
                    "FROM filme, categoriaFilme, categoria " +
                    "WHERE filme.id=id_filme AND categoria.id=id_categoria AND categoria.selecionada=1 " +
                    "GROUP BY filme.nome, duracao, jaViu";

            Cursor cursor = le.rawQuery(consulta,null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceDuracao = cursor.getColumnIndex("duracao");
            int indiceNomeacoes = cursor.getColumnIndex("Nomeacoes");
            int indiceJaViu = cursor.getColumnIndex("jaViu");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                ModelMoviesList new_movie = new ModelMoviesList();

                new_movie.setNome(cursor.getString(indiceNome));
                new_movie.setDuracao(cursor.getInt(indiceDuracao));
                new_movie.setnIndicacoes(cursor.getInt(indiceNomeacoes));
                new_movie.setJaViu(cursor.getInt(indiceJaViu));

                listMovies.add(new_movie);

                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO NA QUERY");
            e.printStackTrace();
        }


        for(ModelMoviesList movie: listMovies) {
            Log.i("RESULTADO - ", " Nome: "+movie.getNome()+" Duracao: "+ movie.getDuracao() +"  Nomeacoes: "+ movie.getnIndicacoes() +
                    " JaViu: "+movie.getJaViu());
        }







        return listMovies;
    }

    public void writeCategoriaSelecionada(SQLiteDatabase escreve, String nome_categoria){
        ContentValues data = new ContentValues();

        try{
            String consulta = "SELECT selecionada FROM categoria WHERE nome='"+nome_categoria+"'";
            Cursor cursor = escreve.rawQuery(consulta,null);
            int indiceSelecionada = cursor.getColumnIndex("selecionada");
            cursor.moveToFirst();
            int selecionada = cursor.getInt(indiceSelecionada);
            cursor.close();

            if(selecionada==0){
                data.put("selecionada", 1);
            }
            else {
                data.put("selecionada", 0);
            }
            escreve.update("categoria", data, "nome= '"+nome_categoria+"'",null);
            Log.i("RESULTADOS -", "foi");
        }catch (Exception e){
            Log.i("RESULTADOS -", "ERRO");
            e.printStackTrace();
        }
    }

    public Pair<String[], Integer[]> readThisMovie(SQLiteDatabase le, String nome_filme){
        String[] movieStrings = new String[2];
        Integer[] movieInts = new Integer[2];

        try{
            String consulta = "SELECT id, duracao, descricao, caminhoImagem " +
                    "FROM filme " +
                    "WHERE filme.nome='"+nome_filme+"'";

            Cursor cursor = le.rawQuery(consulta,null);

            int indiceID = cursor.getColumnIndex("id");
            int indiceDuracao = cursor.getColumnIndex("duracao");
            int indiceDescricao = cursor.getColumnIndex("descricao");
            int indiceCaminhoImagem = cursor.getColumnIndex("caminhoImagem");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                movieInts[0] = cursor.getInt(indiceID);
                movieInts[1] = cursor.getInt(indiceDuracao);
                movieStrings[0] = cursor.getString(indiceDescricao);
                movieStrings[1] = cursor.getString(indiceCaminhoImagem);

                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO NA QUERY");
            e.printStackTrace();
        }
        /*
        for(ModelMoviesList movie: listMovies) {
            Log.i("listMovies - ", " Nome: "+movie.getTituloFilme()+" Duracao: "+ movie.getDuracao() +"  Nomeacoes: "+ movie.getnIndicacoes() +
                    " JaViu: "+movie.getJaViu());
        }
        */

        return new Pair<String[], Integer[]>(movieStrings, movieInts);
    }

    public List<ModelMovieNomination> readMovieSelectedCategories(SQLiteDatabase le, int movie_id){
        List<ModelMovieNomination> listMovieNominations = new ArrayList<>();

        try{
            String consulta = "SELECT categoria.nome, rating, indicado, caminhoImagemIndicado " +
                    "FROM categoriaFilme, categoria " +
                    "WHERE id_filme="+movie_id+" AND id_categoria=id AND selecionada=1";

            Cursor cursor = le.rawQuery(consulta,null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceRating = cursor.getColumnIndex("rating");
            int indiceIndicado = cursor.getColumnIndex("indicado");
            int indiceImagem = cursor.getColumnIndex("caminhoImagemIndicado");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                ModelMovieNomination new_nomination = new ModelMovieNomination();

                new_nomination.setNome_categoria(cursor.getString(indiceNome));
                new_nomination.setRating(cursor.getInt(indiceRating));
                new_nomination.setIndicado(cursor.getString(indiceIndicado));
                new_nomination.setCaminho_imagem_indicado(cursor.getString(indiceImagem));

                listMovieNominations.add(new_nomination);

                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO NA QUERY");
            e.printStackTrace();
        }

        /*
        for(ModelMovieNomination nomination: listMovieNominations) {
            Log.i("listMovies - ", "Categoria: "+nomination.getNome_categoria()+" Rating: "+nomination.getRating()+"\n" +
                    "Indicado: "+nomination.getIndicado()+" Imagem: "+nomination.getCaminho_imagem_indicado());
        }
        */

        return listMovieNominations;
    }

    public Integer[] getMoviesRemaining(SQLiteDatabase le){
        Integer[] numbers = new Integer[2];

        try{
            String consulta = "SELECT COUNT(unicos.ID) AS Numero, SUM(duracao) AS TempoTotal " +
                    "FROM (SELECT DISTINCT filme.id AS ID, duracao " +
                    "   FROM filme " +
                    "   INNER JOIN categoriaFilme ON id_filme=filme.id " +
                    "   INNER JOIN categoria ON id_categoria=categoria.id " +
                    "   WHERE filme.jaViu=0 AND selecionada=1 " +
                    "   ORDER BY filme.id) AS unicos ";

            Cursor cursor = le.rawQuery(consulta,null);

            int indiceNumero = cursor.getColumnIndex("Numero");
            int indiceTempoTotal = cursor.getColumnIndex("TempoTotal");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                numbers[0] = cursor.getInt(indiceNumero);
                numbers[1] = cursor.getInt(indiceTempoTotal);

                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO NA QUERY");
            e.printStackTrace();
        }

        return numbers;
    }

    public List<String> getCategoriesRemaining (SQLiteDatabase le){
        List<String> listCategoriesRemaining = new ArrayList<>();

        try{
            String consulta = "SELECT categoria.nome, SUM(1-jaViu) as jaViu " +
                    "FROM categoria " +
                    "INNER JOIN categoriaFilme ON categoria.id=id_categoria " +
                    "INNER JOIN filme ON filme.id=id_filme " +
                    "WHERE selecionada=1 " +
                    "GROUP BY categoria.nome ";

            Cursor cursor = le.rawQuery(consulta,null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indicejaViu = cursor.getColumnIndex("jaViu");

            cursor.moveToFirst();

            while(!cursor.isAfterLast()){
                int falta_ver = cursor.getInt(indicejaViu);
                if(falta_ver>0){
                    listCategoriesRemaining.add(cursor.getString(indiceNome));
                }

                cursor.moveToNext();
            }

            cursor.close();
        }catch (Exception e){
            Log.i("RESULTADO -", "ERRO NA QUERY");
            e.printStackTrace();
        }

        /*
        for(String category: listCategoriesRemaining) {
            Log.i("RESULTADO - ", "Categoria: "+category);
        }
        */

        return listCategoriesRemaining;
    }
}
