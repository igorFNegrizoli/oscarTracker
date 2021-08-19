package com.example.oscartracker.movie;

public class ModelMovieNomination {
    String nome_categoria;
    String indicado;
    String caminho_imagem_indicado;
    Integer rating;

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
