package com.example.oscartracker.movies_list;

import utils.Utils;

public class ModelMoviesList {

    private String nome;
    private String duracao;
    private String nIndicacoes;
    private Boolean jaViu;

    public ModelMoviesList(){

    }

    public ModelMoviesList(String nome, String duracao, String nIndicacoes, Boolean jaViu) {
        this.nome = nome;
        this.duracao = duracao;
        this.nIndicacoes = nIndicacoes;
        this.jaViu = jaViu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setDuracao(int duracao) {
        Utils utils = new Utils();
        this.duracao = utils.duracaoToString(duracao);
    }

    public String getnIndicacoes() {
        return nIndicacoes;
    }

    public void setnIndicacoes(Integer nIndicacoes) {
        this.nIndicacoes = nIndicacoes.toString();
    }

    public Boolean getJaViu() {
        return jaViu;
    }

    public void setJaViu(Integer jaViu) {
        if(jaViu==1){
            this.jaViu = Boolean.TRUE;
        }
        else{
            this.jaViu = Boolean.FALSE;
        }
    }
}
