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
        setFields(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setFields(this);
    }

    public void setFields(Context context){
        model = new ModelCategories(this);
        category_elements = model.getCategory_elements();

        recyclerView = findViewById(R.id.category_recycler_buttons);
        AdapterCategories adapter = new AdapterCategories(category_elements, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

}