package com.example.oscartracker.settings;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscartracker.R;

import java.util.List;

import database.consultas;
import database.databaseHelper;

public class AdapterSettingsScreen extends RecyclerView.Adapter<AdapterSettingsScreen.MyViewHolder> {
    private List<String> listaCategorias;
    public SQLiteDatabase escreve;

    public AdapterSettingsScreen(List<String> lista, SQLiteDatabase escreve){
        this.listaCategorias = lista;
        this.escreve = escreve;
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
        final consultas consulta = new consultas();
        String categoria = listaCategorias.get(position);
        boolean assistida = consulta.readCategoriaSelecionada(escreve,categoria);
        holder.checkboxCategoria.setText(categoria);
        holder.checkboxCategoria.setChecked(assistida);

        holder.checkboxCategoria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isPressed()){
                consulta.writeCategoriaSelecionada(escreve, categoria, isChecked);
                }
            }
        });
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
