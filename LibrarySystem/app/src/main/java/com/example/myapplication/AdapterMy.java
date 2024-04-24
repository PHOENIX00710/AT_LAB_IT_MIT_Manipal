package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMy extends RecyclerView.Adapter<AdapterMy.ViewHolder> {

    ArrayList<Books> array;
    Context c1;

    public AdapterMy(ArrayList<Books> array, Context c1) {
        this.array = array;
        this.c1 = c1;
    }

    @NonNull
    @Override
    public AdapterMy.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_book,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMy.ViewHolder holder, int position) {
        Books b1 = array.get(position);
        if (b1 != null) {
            holder.t1.setText(b1.getTitle());
            holder.t2.setText(b1.getAuthor());
            holder.t3.setText(String.valueOf(b1.getPrice())); // Ensure it's a string
            holder.itemView.setOnClickListener(v -> {
                Intent i = new Intent(c1, MainActivity2.class);
                i.putExtra("Title", b1.getTitle());
                i.putExtra("Author", b1.getAuthor());
                i.putExtra("Price", b1.getPrice());
                c1.startActivity(i);
            });
        }
    }


    @Override
    public int getItemCount() {
        return array.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.title_book);
            t2=itemView.findViewById(R.id.author);
            t3=itemView.findViewById(R.id.price);
        }
    }
}
