package com.example.oscartracker.movie;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.movie.ModelMovie;
import com.example.oscartracker.movie.ModelMovieNomination;
import com.example.oscartracker.movies_list.AdapterMoviesList;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.List;

public class AdapterNominee extends RecyclerView.Adapter<AdapterNominee.MyViewHolder> {


    private List<ModelMovieNomination> nominationsList;

    public AdapterNominee(List<ModelMovieNomination> lista){
        this.nominationsList = lista;
    }

    @NonNull
    @Override
    public AdapterNominee.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_movie_nominee, parent, false);
        return new AdapterNominee.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelMovieNomination nominee = nominationsList.get(position);
        holder.nome_categoria.setText(nominee.getNome_categoria());
        holder.indicado.setText(nominee.getIndicado());
        holder.rating.setText(String.format(nominee.getRating()+"/5.0"));
        //holder.caminho_imagem_indicado.setText(nominee.getCaminho_imagem_indicado());
        //Log.i("Teste", holder.rating);
        //holder.rating.setRating(nominee.getRating());
    }

    @Override
    public int getItemCount() {
        return nominationsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome_categoria;
        TextView indicado;
        TextView rating;

        public MyViewHolder(View itemView){
            super(itemView);
            nome_categoria = itemView.findViewById(R.id.catName);
            indicado = itemView.findViewById(R.id.nominee);
            rating = itemView.findViewById(R.id.userRating);
        }
    }
}
