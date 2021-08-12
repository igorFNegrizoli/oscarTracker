package com.example.oscartracker.movies_list;

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


public class ActivityMoviesList extends AppCompatActivity {
    private List<ModelMoviesList> listMovies = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        recyclerView = findViewById(R.id.recyclerView);
        this.populateMovies();
        adapter_settings adapter = new adapter_settings(listMovies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void populateMovies(){
        //
        //Addes

    }
}
