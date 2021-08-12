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
        String duracao_text = "";
        int horas = duracao/60;
        int minutos_restantes = duracao%60;
        if(horas>=1){
            duracao_text = duracao_text+horas+"h ";
        }
        if(minutos_restantes==0){
            duracao_text = duracao_text+"00m";
        }
        else if(minutos_restantes<10){
            duracao_text = duracao_text+"0"+minutos_restantes+"m";
        }
        else{
            duracao_text = duracao_text+minutos_restantes+"m";
        }
        this.duracao = duracao_text;
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
