package com.example.oscartracker.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import database.consultas;
import database.databaseHelper;
import utils.Utils;

public class ModelMovie {
    String caminho_imagem;
    String nome_filme;
    String decricao;
    String duracao;
    boolean jaViu;
    List<ModelMovieNomination> indicacoes = new ArrayList<>();
    private int filme_id;
    private SQLiteDatabase le, escreve;
    private final consultas consulta = new consultas();

    public ModelMovie() {
    }

    public void getModelMovieFromDB(Context context, String nome){
        databaseHelper db = new databaseHelper(context);
        Utils utils = new Utils();
        le = db.getReadableDatabase();
        Pair<String[], Integer[]> pair = consulta.readThisMovie(le, nome);

        this.nome_filme = nome;
        this.decricao = pair.first[0];
        this.caminho_imagem = pair.first[1];
        this.filme_id = pair.second[0];
        this.duracao = utils.duracaoToString(pair.second[1]);
        if(pair.second[2]==0){
            this.jaViu=false;
        }else{
            this.jaViu=true;
        }

        this.indicacoes = consulta.readMovieSelectedCategories(le, filme_id);
        le.close();
    }

    public void saveInfoToDB(Context context){
        databaseHelper db = new databaseHelper(context);
        escreve = db.getWritableDatabase();

        consulta.writeFilmeJaViu(escreve, filme_id, jaViu);
        for(ModelMovieNomination indicacao: indicacoes){
            consulta.writeNotaFilmeCategoria(escreve, filme_id, indicacao.getNome_categoria(), indicacao.getRating());
        }

        escreve.close();
    }

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
    }

    public String getNome_filme() {
        return nome_filme;
    }

    public void setNome_filme(String nome_filme) {
        this.nome_filme = nome_filme;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public List<ModelMovieNomination> getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(List<ModelMovieNomination> indicacoes) {
        this.indicacoes = indicacoes;
    }

    public boolean isJaViu() {
        return jaViu;
    }

    public void setJaViu(boolean jaViu) {
        this.jaViu = jaViu;
    }
}
