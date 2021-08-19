package com.example.oscartracker.dashboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.List;

import database.consultas;
import database.databaseHelper;
import utils.Utils;

public class ModelDashboard {
    Integer movies_remaining;
    String time_remaining;
    Integer num_categories_remaining;
    List<String> categories_remaining;
    private SQLiteDatabase le;
    private final consultas consulta = new consultas();

    public ModelDashboard() {
    }

    public void getModelDashboardFromDB(Context context){
        databaseHelper db = new databaseHelper(context);
        Utils utils = new Utils();
        le = db.getReadableDatabase();
        Integer[] pair = consulta.getMoviesRemaining(le);

        this.movies_remaining = pair[0];
        this.time_remaining = utils.duracaoToString(pair[1]);
        this.categories_remaining = consulta.getCategoriesRemaining(le);
        this.num_categories_remaining = this.categories_remaining.size();

        le.close();
    }

    public Integer getMovies_remaining() {
        return movies_remaining;
    }

    public void setMovies_remaining(Integer movies_remaining) {
        this.movies_remaining = movies_remaining;
    }

    public String getTime_remaining() {
        return time_remaining;
    }

    public void setTime_remaining(String time_remaining) {
        this.time_remaining = time_remaining;
    }

    public Integer getNum_categories_remaining() {
        return num_categories_remaining;
    }

    public void setNum_categories_remaining(Integer num_categories_remaining) {
        this.num_categories_remaining = num_categories_remaining;
    }

    public List<String> getCategories_remaining() {
        return categories_remaining;
    }

    public void setCategories_remaining(List<String> categories_remaining) {
        this.categories_remaining = categories_remaining;
    }
}
