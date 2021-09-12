package com.example.oscartracker.categories;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
        String category = category_elements.get(position).first;
        holder.button.setText(category);

    }

    @Override
    public int getItemCount() {
        return category_elements.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public MyViewHolder(View itemView){
            super(itemView);
            button = itemView.findViewById(R.id.base_cardview);
        }
    }
}
