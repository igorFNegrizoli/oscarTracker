package com.example.oscartracker.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.oscartracker.R;
import com.example.oscartracker.movies_list.AdapterMoviesList;

import database.databaseHelper;

public class ActivityCategories extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SQLiteDatabase le;
    private ModelCategories model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);
        model = new ModelCategories(this);

        AdapterCategories adapter = new AdapterCategories(model.categories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);



    }

}