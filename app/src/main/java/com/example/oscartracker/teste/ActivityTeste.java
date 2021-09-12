package com.example.oscartracker.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;

import com.example.oscartracker.R;
import com.example.oscartracker.categories.ModelCategoryMovies;

public class ActivityTeste extends AppCompatActivity {
    ModelTeste var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste);
        var = new ModelTeste(this);

        /*
        for(int i=0; i<var.categories.size(); i++){
            Log.i("Teste3 ", "categoria: "+var.categories.get(i));
            ModelCategoryMovies categoryMovies = var.categoryMovies.get(i);
            for(Pair<String, Integer> parFilme: categoryMovies.getFilmesNotas()){
                Log.i("Teste3", "Filme: "+parFilme.first+"Nota: "+parFilme.second);
            }

        }*/


        for(Pair<String, ModelCategoryMovies> par: var.category_elements){
            Log.i("Teste3: ", "categoria "+par.first);
            for(Pair<String, Integer> parFilme: par.second.getFilmesNotas()){
                Log.i("Teste3", "Filme: "+parFilme.first+" Nota: "+parFilme.second);
            }
        }



    }
}