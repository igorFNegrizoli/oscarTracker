package com.example.oscartracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.os.Bundle;

import database.consultas;
import database.databaseHelper;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {
    SQLiteDatabase le, escreve;
    final consultas consulta = new consultas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        databaseHelper db = new databaseHelper(this);
        //le = db.getReadableDatabase();
        escreve = db.getWritableDatabase();

        /*
        consulta.consultaTodosCategorias(escreve);
        consulta.writeCategoriaSelecionada(escreve, "International Feature Film");
        consulta.consultaTodosCategorias(escreve);
        */

        //consulta.consultaFilmes(le);
        //consulta.consultaCategorias(le);
        //consulta.consultaFilmeCategorias(le);
        //consulta.consultaMoviesList(escreve);

        //Splash Screen duration
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash_screen.this, dashboard.class));
                finish();
            }
        }, secondsDelayed * 3000);
    }
}