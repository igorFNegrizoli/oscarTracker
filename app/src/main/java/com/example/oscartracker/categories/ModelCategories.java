package com.example.oscartracker.categories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

import database.consultas;
import database.databaseHelper;

public class ModelCategories {
    List<Pair<String, ModelCategoryMovies>> category_elements;
    List<String> categories;
    List<ModelCategoryMovies> categoryMovies;

    public ModelCategories(Context context) {
        SQLiteDatabase le;
        final consultas consulta = new consultas();
        databaseHelper db = new databaseHelper(context);
        le = db.getReadableDatabase();

        this.categories = consulta.readSelectedCategories(le);

        this.categoryMovies = new ArrayList<>();

        for(String categoria: this.categories){
            ModelCategoryMovies categoryMovies = new ModelCategoryMovies(le, categoria);
            this.categoryMovies.add(categoryMovies);
        }

        category_elements = new ArrayList<>();

        for(int i=0; i<categories.size(); i++){
            Pair<String, ModelCategoryMovies> par = new Pair(this.categories.get(i), this.categoryMovies.get(i));
            category_elements.add(par);
        }


        le.close();
    }

    public List<Pair<String, ModelCategoryMovies>> getCategory_elements() {
        return category_elements;
    }

    public void setCategory_elements(List<Pair<String, ModelCategoryMovies>> category_elements) {
        this.category_elements = category_elements;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<ModelCategoryMovies> getCategoryMovies() {
        return categoryMovies;
    }

    public void setCategoryMovies(List<ModelCategoryMovies> categoryMovies) {
        this.categoryMovies = categoryMovies;
    }
}
