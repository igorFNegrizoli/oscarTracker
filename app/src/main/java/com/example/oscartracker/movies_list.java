package com.example.oscartracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class movies_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);
    }

    public void open_movies(View view) {
        Intent intent = new Intent(this, movies.class);
        startActivity(intent);
    }

}