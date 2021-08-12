package com.example.oscartracker.settings;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.settings.adapter_settings;

import java.util.ArrayList;
import java.util.List;


public class activity_settings extends AppCompatActivity {
    private List<String> listaCategorias = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        recyclerView = findViewById(R.id.recyclerView);
        this.populateLista();
        adapter_settings adapter = new adapter_settings(listaCategorias);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void populateLista(){
        //
        //Addes
        listaCategorias.add("Best Picture");
        listaCategorias.add("Actor in a Leading Role");
        listaCategorias.add("Actor in a Supporting Role");
        listaCategorias.add("Actress in a Leading Role");
        listaCategorias.add("Actress in a Supporting Role");
        listaCategorias.add("Animated Feature Film");
        listaCategorias.add("Cinematography");
        listaCategorias.add("Costume Design");
        listaCategorias.add("Directing");
        listaCategorias.add("Documentary (Feature)");
        listaCategorias.add("Documentary (Short Subject)");
        listaCategorias.add("Film Editing");
        listaCategorias.add("International Feature Film");
        listaCategorias.add("Makeup and Hairstyling");
        listaCategorias.add("Music (Original Score)");
        listaCategorias.add("Music (Original Song)");
        listaCategorias.add("Best Picture");
        listaCategorias.add("Production Design");
        listaCategorias.add("Short Film (Animated)");
        listaCategorias.add("Short Film (Live Action)");
        listaCategorias.add("Sound");
        listaCategorias.add("Visual Effects");
        listaCategorias.add("Writing (Adapted Screenplay)");
        listaCategorias.add("Writing (Original Screenplay)");
    }
}