package com.example.oscartracker.movie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import database.consultas;
import database.databaseHelper;

public class ModelMovieNomination {
    String nome_categoria;
    String indicado;
    String caminho_imagem_indicado;
    Integer rating;
    private int filme_id;

    public void writeToDB(Context context){
        SQLiteDatabase escreve;
        final consultas consulta = new consultas();
        databaseHelper db = new databaseHelper(context);
        escreve = db.getWritableDatabase();

        consulta.writeNotaFilmeCategoria(escreve, filme_id, nome_categoria, rating);
    }

    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public ModelMovieNomination() {
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getIndicado() {
        return indicado;
    }

    public void setIndicado(String indicado) {
        this.indicado = indicado;
    }

    public String getCaminho_imagem_indicado() {
        return caminho_imagem_indicado;
    }

    public void setCaminho_imagem_indicado(String caminho_imagem_indicado) {
        this.caminho_imagem_indicado = caminho_imagem_indicado;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
