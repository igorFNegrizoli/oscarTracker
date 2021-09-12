package com.example.oscartracker.categories;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.oscartracker.R;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.ArrayList;
import java.util.List;

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.MyViewHolder> {
    private List<Pair<String, ModelCategoryMovies>> category_elements;

    public AdapterCategories(List<Pair<String, ModelCategoryMovies>> lista){
        this.category_elements = lista;
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
        Log.i("Teste3", "size: "+size);

        String category = category_elements.get(position).first;
        holder.button.setText(category);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.hiddenView.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.hiddenView.setVisibility(View.GONE);
                }

                else {
                    TransitionManager.beginDelayedTransition(holder.cardView, new AutoTransition());
                    holder.hiddenView.setVisibility(View.VISIBLE);
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
        LinearLayout hiddenView;
        CardView cardView;
        Button buttonView;

        public MyViewHolder(View itemView){
            super(itemView);
            button = itemView.findViewById(R.id.cat_button);
            hiddenView = itemView.findViewById(R.id.hidden_view);
            cardView = itemView.findViewById(R.id.base_cardview);
            buttonView = itemView.findViewById(R.id.cat_button);
        }
    }
}
