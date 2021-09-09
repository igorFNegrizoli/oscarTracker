package com.example.oscartracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.os.Bundle;

import database.consultas;
import database.databaseHelper;
import android.os.Handler;

import com.example.oscartracker.dashboard.ActivityDashboard;

public class SplashScreen extends AppCompatActivity {
    SQLiteDatabase le, escreve;
    final consultas consulta = new consultas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        databaseHelper db = new databaseHelper(this);
        le = db.getReadableDatabase();
        escreve = db.getWritableDatabase();

        //escreve = db.getWritableDatabase();
        //consulta.consultaTodosFilmes(le);
        //consulta.consultaTodosCategorias(le);
        //consulta.consultaTodosFilmeCategorias(le);
        //consulta.consultaMoviesList(le);

        /*
        consulta.readThisMovie(le,"Minari");
        consulta.readMovieSelectedCategories(le, 1);

        consulta.writeFilmeJaViu(escreve, 1, false);
        consulta.writeNotaFilmeCategoria(escreve, 1, "Best Picture", 5);

        consulta.readThisMovie(le, "Minari");
        consulta.readMovieSelectedCategories(le, 1);
        */

        //consulta.writeCategoriaSelecionada(escreve, "International Feature Film");
        //consulta.getCategoriesRemaining(le);

        //Splash Screen duration
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreen.this, ActivityDashboard.class));
                finish();
            }
        }, secondsDelayed * 3000);
    }
}