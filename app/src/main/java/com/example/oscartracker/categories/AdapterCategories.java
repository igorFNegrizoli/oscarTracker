package com.example.oscartracker.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.List;

public class AdapterCategories extends RecyclerView.Adapter<AdapterMoviesList.MyViewHolder> {
    private List<String> categoriesList;

    public AdapterCategories(List<String> lista){
        this.categoriesList = lista;
    }

    @NonNull
    @Override
    public AdapterCategories.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category_button, parent, false);
        return new AdapterCategories.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMoviesList.MyViewHolder holder, int position) {
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
