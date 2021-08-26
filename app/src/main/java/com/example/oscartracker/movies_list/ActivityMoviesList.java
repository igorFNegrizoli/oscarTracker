package com.example.oscartracker.movies_list;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.movie.Movie;
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
    //View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        /*decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility == 0) decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
        */

        //Transparent action bar
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

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
                                Intent i = new Intent(ActivityMoviesList.this, Movie.class);
                                i.putExtra("nomeFilme", filme.getNome());
                                startActivity(i);
                                //Toast.makeText(getApplicationContext(), "Curto: " + filme.getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }
/*
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
*/
    public void populateMovies(){
        databaseHelper db = new databaseHelper(this);
        le = db.getReadableDatabase();
        this.listMovies = consulta.consultaMoviesList(le);
        le.close();
    }
}
