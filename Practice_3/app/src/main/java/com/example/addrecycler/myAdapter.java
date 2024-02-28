package com.example.addrecycler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHoler> {

    ArrayList<Item> items;
    Context c1;
    ArrayList<String> amount;
    static int total=0;

    public myAdapter(ArrayList<Item> items, Context c1) {
        this.items = items;
        this.c1 = c1;
    }

    @NonNull
    @Override
    public myAdapter.viewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart,parent,false);
        return  new viewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHoler holder, int position) {
        Item model=items.get(position);
        holder.item.setText(model.getItem());
        holder.amount.setText(model.getAmount());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Alert

                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);

                // Set the message show for the Alert time
                builder.setMessage("Do you want to add this to Cart ?");

                // Set Alert Title
                builder.setTitle("Alert !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    total+=Integer.parseInt(model.getAmount());
                });

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHoler extends RecyclerView.ViewHolder {

        TextView amount,item;
        Button add;
        public viewHoler(@NonNull View itemView) {
            super(itemView);
            amount=itemView.findViewById(R.id.amountValue);
            item=itemView.findViewById(R.id.itemValue);
            add=itemView.findViewById(R.id.addToList);
        }
    }
}
