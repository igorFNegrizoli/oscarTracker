package com.example.oscartracker.categories;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.movie.AdapterNominee;
import com.example.oscartracker.movie.ModelMovieNomination;

import java.util.List;

public class AdapterLittleDrawer extends RecyclerView.Adapter<AdapterLittleDrawer.MyViewHolder>{
    private List<Pair<String,Integer>> filmesNotas;

    public AdapterLittleDrawer(List<Pair<String,Integer>> lista){
        this.filmesNotas = lista;
    }

    @NonNull
    @Override
    public AdapterLittleDrawer.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category_movies, parent, false);
        return new AdapterLittleDrawer.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLittleDrawer.MyViewHolder holder, int position) {
        Pair<String,Integer> filmeNota = filmesNotas.get(position);
        holder.nome_filme.setText(filmeNota.first);
        float real_rating = (float) filmeNota.second;
        real_rating /= 10.0;
        holder.rating.setText(String.format(real_rating+"/5.0"));
    }

    @Override
    public int getItemCount() {
        return filmesNotas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome_filme;
        TextView rating;

        public MyViewHolder(View itemView){
            super(itemView);
            nome_filme = itemView.findViewById(R.id.movieName);
            rating = itemView.findViewById(R.id.userRating);
        }
    }
}
