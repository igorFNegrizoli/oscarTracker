package com.example.oscartracker.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.oscartracker.R;
import com.example.oscartracker.RecyclerItemClickListener;
import com.example.oscartracker.movie.ActivityMovie;
import com.example.oscartracker.movies_list.ActivityMoviesList;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.ArrayList;
import java.util.List;

import database.databaseHelper;

public class ActivityCategories extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SQLiteDatabase le;
    private ModelCategories model;
    private List<Pair<String, ModelCategoryMovies>> category_elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);
        model = new ModelCategories(this);
        category_elements = model.getCategory_elements();

        /*
        //recyclerView = findViewById(R.id.categoriesBaseRecyclerView);
        AdapterCategories adapter = new AdapterCategories(category_elements);
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
                                //ModelCategories category = listMovies.get(position);
                                //Intent i = new Intent(ActivityMoviesList.this, ActivityMovie.class);
                                //i.putExtra("nomeFilme", filme.getNome());
                                //startActivity(i);
                                Toast.makeText(getApplicationContext(), "Curto: " + category_elements.get(position).first, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

         */


    }

}