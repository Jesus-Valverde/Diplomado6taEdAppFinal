package com.example.diplomado6taedappfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<Model> models;

    public MainAdapter(Context context, ArrayList<Model> models)  {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(models.get(position).getId());
        holder.nombre.setText(models.get(position).getNombre());
        holder.apellidos.setText(models.get(position).getApellidos());
        holder.correo.setText(models.get(position).getCorreo());
        holder.grupo.setText(models.get(position).getGrupo());

    }

    @Override
    public int getItemCount() {
        return models.size( );
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, nombre, apellidos, correo, grupo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            apellidos = itemView.findViewById(R.id.apellidos);
            correo = itemView.findViewById(R.id.correo);
            grupo = itemView.findViewById(R.id.grupo);
        }
    }
}
