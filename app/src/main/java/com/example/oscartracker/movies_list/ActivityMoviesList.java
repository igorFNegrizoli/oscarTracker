package com.example.oscartracker.movies_list;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import database.consultas;
import database.databaseHelper;


public class ActivityMoviesList extends AppCompatActivity {
    private SQLiteDatabase le;
    private final consultas consulta = new consultas();
    private List<ModelMoviesList> listMovies = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        recyclerView = findViewById(R.id.recyclerView);
        this.populateMovies();
        AdapterMoviesList adapter = new AdapterMoviesList(listMovies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                ModelMoviesList filme = listMovies.get(position);
                                Toast.makeText(getApplicationContext(), "Curto", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                ModelMoviesList filme = listMovies.get(position);
                                Toast.makeText(getApplicationContext(), "Longo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void populateMovies(){
        databaseHelper db = new databaseHelper(this);
        le = db.getReadableDatabase();
        this.listMovies = consulta.consultaMoviesList(le);
    }
}
