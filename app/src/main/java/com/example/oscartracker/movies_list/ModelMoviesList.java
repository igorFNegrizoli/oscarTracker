package com.example.oscartracker.movies_list;

public class ModelMoviesList {

    private String tituloFilme;
    private String duracao;
    private String nIndicacoes;
    private Boolean jaViu;

    public ModelMoviesList(){

    }

    public ModelMoviesList(String tituloFilme, String duracao, String nIndicacoes, Boolean jaViu) {
        this.tituloFilme = tituloFilme;
        this.duracao = duracao;
        this.nIndicacoes = nIndicacoes;
        this.jaViu = jaViu;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
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
