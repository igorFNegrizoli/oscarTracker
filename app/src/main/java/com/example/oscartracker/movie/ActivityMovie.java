package com.example.oscartracker.movie;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.RecyclerItemClickListener;
import com.example.oscartracker.movies_list.ActivityMoviesList;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import database.consultas;
import database.databaseHelper;


public class ActivityMovie extends AppCompatActivity {

    private List<ModelMovieNomination> listNominees = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        //Typeface type = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        //TextView.setTypeface(type);
        //View imagevi = (ImageView) findViewById(R.id.imageView0);
        //imagevi.setEnabled(false);

        //content behind status bar and navigation bar
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //TextView titleTextView = (TextView)findViewById(R.id.myAwesomeTextView);
        ModelMovie filme = new ModelMovie();
        filme.getModelMovieFromDB(this, getIntent().getStringExtra("nomeFilme"));

        //Setting text atribbutes
        TextView titleTextView = (TextView)findViewById(R.id.movieTitle);
        titleTextView.setText(filme.getNome_filme());

        TextView descriptionTextView = (TextView)findViewById(R.id.movieDescription);
        descriptionTextView.setText(filme.getDecricao());

        TextView durationTextView = (TextView)findViewById(R.id.movieDuration);
        durationTextView.setText(filme.getDuracao());

        int resId = this.getResources().getIdentifier(filme.getCaminho_imagem(), "drawable", this.getPackageName());
        ImageView myImage = (ImageView) findViewById(R.id.imageMovie);
        myImage.setImageResource(resId);

        Switch jaViuSwitch = (Switch)findViewById(R.id.switch3);
        jaViuSwitch.setChecked(filme.isJaViu());

        Context ctxt = this;

        jaViuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isPressed()){
                    filme.setJaViu(isChecked);
                    filme.saveInfoToDB(ctxt);
                }
            }
        });

        //Set recycler view
        recyclerView = findViewById(R.id.recyclerViewNominations);
        this.listNominees = filme.getIndicacoes();
        AdapterNominee adapter = new AdapterNominee(listNominees);
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
                                ModelMovieNomination nomination = listNominees.get(position);
                                onButtonShowPopupWindowClick(view, nomination);
                                //Toast.makeText(getApplicationContext(), "Curto: " + nomination.getIndicado(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


    }

    public void back_to_previous(View view){
        finish();
    }

    public static void dimBehind(PopupWindow popupWindow) {
        View container = popupWindow.getContentView().getRootView();
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.6f;
        wm.updateViewLayout(container, p);
    }

    public void onButtonShowPopupWindowClick(View view, ModelMovieNomination nomination) {
        Log.i("Teste", "Nome Categoria: "+nomination.getNome_categoria());
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_movies, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        TextView catName = popupWindow.getContentView().findViewById(R.id.catNamePopup);
        TextView nominee = popupWindow.getContentView().findViewById(R.id.nomineePopup);
        ImageView image = popupWindow.getContentView().findViewById(R.id.nomineeImagePopup);
        RatingBar ratingBar = popupWindow.getContentView().findViewById(R.id.ratingBarPopup);

        catName.setText(nomination.getNome_categoria());
        if(nomination.getIndicado() != null){
            nominee.setText(nomination.getIndicado());
            int resId = this.getResources().getIdentifier(nomination.getCaminho_imagem_indicado(), "drawable", this.getPackageName());
            image.setImageResource(resId);
        }
        ratingBar.setRating(nomination.getRating());

        dimBehind(popupWindow);
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                //imagevi.setEnabled(false);
                return true;
            }
        });
    }

}