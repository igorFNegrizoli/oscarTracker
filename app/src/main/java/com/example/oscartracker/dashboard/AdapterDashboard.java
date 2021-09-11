package com.example.oscartracker.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;
import com.example.oscartracker.movies_list.ModelMoviesList;

import java.util.List;

public class AdapterDashboard extends RecyclerView.Adapter<com.example.oscartracker.dashboard.AdapterDashboard.MyViewHolder> {

    private List<String> catList;

    public AdapterDashboard(List<String> lista){
        this.catList = lista;
    }

    @NonNull
    @Override
    public com.example.oscartracker.dashboard.AdapterDashboard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_dashboard_categories, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.oscartracker.dashboard.AdapterDashboard.MyViewHolder holder, int position) {
        holder.category.setText(catList.get(position));

    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button category;

        public MyViewHolder(View itemView){
            super(itemView);
            category = itemView.findViewById(R.id.buttonDashboard);
        }
    }
}

