package com.example.oscartracker.categories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.List;

import database.consultas;
import database.databaseHelper;
import utils.Utils;

public class ModelCategoryMovies {
    List<Pair<String,Integer>> filmesNotas;

    public List<Pair<String, Integer>> getFilmesNotas() {
        return filmesNotas;
    }

    public void setFilmesNotas(List<Pair<String, Integer>> filmesNotas) {
        this.filmesNotas = filmesNotas;
    }

    public ModelCategoryMovies(SQLiteDatabase le, String category) {
        final consultas consulta = new consultas();
        this.filmesNotas =  consulta.readCategoriaFilmesNotas(le, category);
    }
}
