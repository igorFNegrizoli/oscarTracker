package com.example.oscartracker.categories;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.oscartracker.R;
import com.example.oscartracker.RecyclerItemClickListener;
import com.example.oscartracker.movie.ActivityMovie;
import com.example.oscartracker.movies_list.ActivityMoviesList;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.MyViewHolder> {
    private List<Pair<String, ModelCategoryMovies>> category_elements;
    private Utils utils = new Utils();
    private Context ctxt;

    public AdapterCategories(List<Pair<String, ModelCategoryMovies>> lista, Context context){
        this.category_elements = lista;
        this.ctxt = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category_button, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int size = category_elements.size();

        String category = category_elements.get(position).first;
        holder.button.setText(category);
        int resId = ctxt.getResources().getIdentifier(utils.categoryButtonName(category), "drawable", ctxt.getPackageName());

        Drawable img = ctxt.getResources().getDrawable(resId);
        img.setBounds(0, 0, 60, 60);
        holder.button.setCompoundDrawables(img, null, null, null);

        //Hidden recycler
        AdapterLittleDrawer adapter = new AdapterLittleDrawer(category_elements.get(position).second.filmesNotas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ctxt);
        holder.recycler.setLayoutManager(layoutManager);
        holder.recycler.setHasFixedSize(true);
        holder.recycler.setAdapter(adapter);

        holder.recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        ctxt,
                        holder.recycler,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int positionFilme) {
                                String filme = category_elements.get(position).second.filmesNotas.get(positionFilme).first;
                                Intent i = new Intent(ctxt, ActivityMovie.class);
                                i.putExtra("nomeFilme", filme);
                                ctxt.startActivity(i);
                                //Toast.makeText(getApplicationContext(), "Curto: " + filme.getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.recycler.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.recycler.setVisibility(View.GONE);
                }

                else {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.recycler.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return category_elements.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button button;
        //LinearLayout hiddenView;
        CardView cardView;
        Button buttonView;
        RecyclerView recycler;

        public MyViewHolder(View itemView){
            super(itemView);
            button = itemView.findViewById(R.id.cat_button);
            //hiddenView = itemView.findViewById(R.id.hidden_view);
            cardView = itemView.findViewById(R.id.base_cardview);
            buttonView = itemView.findViewById(R.id.cat_button);
            recycler = itemView.findViewById(R.id.hidden_view_little_drawer);
        }
    }
}
