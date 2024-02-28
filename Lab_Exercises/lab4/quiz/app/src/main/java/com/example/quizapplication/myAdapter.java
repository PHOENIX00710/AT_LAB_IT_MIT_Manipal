package com.example.quizapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {

    ArrayList<Quiz> arr1;
    Context c1;

    public myAdapter(ArrayList<Quiz> arr1, Context c1) {
        this.arr1 = arr1;
        this.c1 = c1;
    }

    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(c1).inflate(R.layout.my_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {
        Quiz model=arr1.get(position);
        holder.question.setText(model.getQuestion());
        holder.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(holder.trueAnswer.getId() == checkedId){
                    MainActivity.answers[holder.getAdapterPosition()]=1;
                }
                else if(holder.falseAnswer.getId() == checkedId){
                    MainActivity.answers[holder.getAdapterPosition()]=0;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr1.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView question;
        RadioGroup group1;
        RadioButton trueAnswer,falseAnswer;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            question= itemView.findViewById(R.id.question);
            group1=itemView.findViewById(R.id.answer);
            trueAnswer=itemView.findViewById(R.id.trueRadioButton);
            falseAnswer=itemView.findViewById(R.id.falseRadioButton);
        }
    }
}
