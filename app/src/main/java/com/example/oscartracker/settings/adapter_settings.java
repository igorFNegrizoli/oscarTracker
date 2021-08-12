package com.example.oscartracker.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;

import java.util.List;

public class adapter_settings extends RecyclerView.Adapter<adapter_settings.MyViewHolder> {
    private List<String> listaCategorias;

    public adapter_settings(List<String> lista){
        this.listaCategorias = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_setting, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String categoria = listaCategorias.get(position);
        holder.checkboxCategoria.setText(categoria);
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkboxCategoria;

        public MyViewHolder(View itemView){
            super(itemView);
            checkboxCategoria = itemView.findViewById(R.id.checkBox_settings);
        }
    }
}
