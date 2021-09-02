package com.example.oscartracker.settings;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;

import java.util.ArrayList;
import java.util.List;

import database.databaseHelper;


public class ActivitySettingsScreen extends AppCompatActivity {
    private List<String> listaCategorias = new ArrayList<>();
    private RecyclerView recyclerView;
    private databaseHelper db;
    private SQLiteDatabase escreve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        db = new databaseHelper(this);
        escreve = db.getWritableDatabase();

        recyclerView = findViewById(R.id.recyclerView);
        this.populateLista();
        AdapterSettingsScreen adapter = new AdapterSettingsScreen(listaCategorias, escreve);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void populateLista(){
        listaCategorias.add("Best Picture");
        listaCategorias.add("Actor in a Leading Role");
        listaCategorias.add("Actor in a Supporting Role");
        listaCategorias.add("Actress in a Leading Role");
        listaCategorias.add("Actress in a Supporting Role");
        listaCategorias.add("Directing");
        listaCategorias.add("Writing (Adapted Screenplay)");
        listaCategorias.add("Writing (Original Screenplay)");
        listaCategorias.add("International Feature Film");
        listaCategorias.add("Documentary (Feature)");
        listaCategorias.add("Animated Feature Film");
        listaCategorias.add("Cinematography");
        listaCategorias.add("Film Editing");
        listaCategorias.add("Short Film (Animated)");
        listaCategorias.add("Short Film (Live Action)");
        listaCategorias.add("Documentary (Short Subject)");
        listaCategorias.add("Sound");
        listaCategorias.add("Music (Original Score)");
        listaCategorias.add("Music (Original Song)");
        listaCategorias.add("Production Design");
        listaCategorias.add("Visual Effects");
        listaCategorias.add("Makeup and Hairstyling");
        listaCategorias.add("Costume Design");
    }
}