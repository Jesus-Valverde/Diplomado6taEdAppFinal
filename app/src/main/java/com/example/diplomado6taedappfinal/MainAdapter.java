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
        holder.issueNumber.setText(models.get(position).getIssueNumber());
        holder.onSaleDate.setText(models.get(position).getOnSaleDate());
        holder.pageCount.setText(models.get(position).getPageCount());
        holder.title.setText(models.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return models.size( );
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, issueNumber, onSaleDate, pageCount, title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            issueNumber = itemView.findViewById(R.id.issueNumber);
            onSaleDate = itemView.findViewById(R.id.onSaleDate);
            pageCount = itemView.findViewById(R.id.pageCount);
            title = itemView.findViewById(R.id.title);
        }
    }
}
