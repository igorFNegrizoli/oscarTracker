package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Display;

import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.ArrayList;
import java.util.List;

public class consultas {
    private void consultaTodosFilmes(SQLiteDatabase le){
        try{
            String consulta = "SELECT * FROM filme";
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
        /*
        for(ModelMoviesList movie: listMovies) {
            Log.i("listMovies - ", " Nome: "+movie.getTituloFilme()+" Duracao: "+ movie.getDuracao() +"  Nomeacoes: "+ movie.getnIndicacoes() +
                    " JaViu: "+movie.getJaViu());
        }
        */

        return listMovies;
    }


    public void writeCategoriaSelecionada(SQLiteDatabase escreve, String nome_categoria){
        ContentValues data = new ContentValues();
        data.put("selecionada", 0);

        try{
            escreve.update("categoria", data, "nome= '"+nome_categoria+"'",null);
            Log.i("RESULTADOS -", "foi");
        }catch (Exception e){
            Log.i("RESULTADOS -", "ERRO");
            e.printStackTrace();
        }
    }
}
