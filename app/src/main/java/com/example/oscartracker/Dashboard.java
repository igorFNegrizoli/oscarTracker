package com.example.oscartracker;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.oscartracker.movies_list.ActivityMoviesList;
import com.example.oscartracker.settings.ActivitySettingsScreen;

import database.databaseHelper;


public class Dashboard extends AppCompatActivity {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);

        /*
        databaseHelper db = new databaseHelper(this);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

         */
    }

    public void open_movies_list(View view){
        Intent intent = new Intent(this, ActivityMoviesList.class);
        startActivity(intent);
    }

    public void open_settings(View view){
        Intent intent = new Intent(this, ActivitySettingsScreen.class);
        startActivity(intent);
    }

    public void open_categories(View view) {
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }

    public void open_picks(View view) {
        Intent intent = new Intent(this, Picks.class);
        startActivity(intent);
    }

}