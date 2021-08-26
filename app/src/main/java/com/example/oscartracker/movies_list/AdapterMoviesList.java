package com.example.oscartracker.movies_list;

import android.graphics.ColorSpace;
import android.graphics.Movie;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.MockView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;

import java.util.List;

public class AdapterMoviesList extends RecyclerView.Adapter<AdapterMoviesList.MyViewHolder> {

    private List<ModelMoviesList> moviesList;

    public AdapterMoviesList(List<ModelMoviesList> lista){
        this.moviesList = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_movie_in_list, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelMoviesList movie = moviesList.get(position);
        holder.nome.setText(movie.getNome());
        holder.duracao.setText(movie.getDuracao());
        holder.nIndicacoes.setText(movie.getnIndicacoes());

        if(movie.getJaViu()){
            holder.jaViu.setImageResource(R.drawable.icon_checknobox_true);
        }else{
            holder.jaViu.setImageResource(R.drawable.icon_checknobox_false);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView duracao;
        TextView nIndicacoes;
        ImageView jaViu;

        public MyViewHolder(View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            duracao = itemView.findViewById(R.id.duracao);
            nIndicacoes = itemView.findViewById(R.id.nIndicacoes);
            jaViu = itemView.findViewById(R.id.jaViu);
        }
    }
}
