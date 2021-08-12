package com.example.oscartracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.os.Bundle;

import database.consultas;
import database.databaseHelper;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    SQLiteDatabase le;
    final consultas consulta = new consultas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        databaseHelper db = new databaseHelper(this);
        le = db.getReadableDatabase();
        //consulta.consultaTodosFilmes(le);
        //consulta.consultaCategorias(le);
        //consulta.consultaFilmeCategorias(le);
        //consulta.consultaMoviesList(le);

        //Splash Screen duration
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreen.this, Dashboard.class));
                finish();
            }
        }, secondsDelayed * 3000);
    }
}