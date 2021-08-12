package com.example.oscartracker.movies_list;

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

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getnIndicacoes() {
        return nIndicacoes;
    }

    public void setnIndicacoes(String nIndicacoes) {
        this.nIndicacoes = nIndicacoes;
    }

    public Boolean getJaViu() {
        return jaViu;
    }

    public void setJaViu(Boolean jaViu) {
        this.jaViu = jaViu;
    }
}
