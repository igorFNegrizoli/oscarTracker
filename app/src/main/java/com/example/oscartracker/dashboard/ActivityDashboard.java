package com.example.oscartracker.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.oscartracker.categories.ActivityCategories;
import com.example.oscartracker.Picks;
import com.example.oscartracker.R;
import com.example.oscartracker.movies_list.ActivityMoviesList;
import com.example.oscartracker.settings.ActivitySettingsScreen;


public class ActivityDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setFields(this);

        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);

        /*
        databaseHelper db = new databaseHelper(this);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

         */
    }

    @Override
    public void onResume()
    {
        super.onResume();
        setFields(this);
    }

    private void setFields(Context context){
        TextView moviesRemaining = findViewById(R.id.textView62);
        TextView timeRemaining = findViewById(R.id.textView63);
        TextView categoriesRemaining = findViewById(R.id.textView64);

        ModelDashboard model = new ModelDashboard();
        model.getModelDashboardFromDB(context);

        moviesRemaining.setText(model.movies_remaining);
        timeRemaining.setText(model.time_remaining);
        categoriesRemaining.setText(model.num_categories_remaining_text);

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
        Intent intent = new Intent(this, ActivityCategories.class);
        startActivity(intent);
    }

    public void open_picks(View view) {
        Intent intent = new Intent(this, Picks.class);
        startActivity(intent);
    }

}