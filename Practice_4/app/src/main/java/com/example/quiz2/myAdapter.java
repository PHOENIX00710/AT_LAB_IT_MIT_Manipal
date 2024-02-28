package com.example.quiz2;

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

    ArrayList<Question> questions;
    Context c1;


    public myAdapter(ArrayList<Question> questions, Context c1) {
        this.questions = questions;
        this.c1 = c1;
    }

    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(c1).inflate(R.layout.quiz_question,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {
        Question model=questions.get(position);
        holder.q.setText(model.getQuestion());
        holder.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(holder.truebtn.isChecked()){
                    if(model.isAnswer()){
                        MainActivity.arr[position]=1;
                    }
                    else
                        MainActivity.arr[position]=0;
                }
                if(holder.falseBtn.isChecked()){
                    if(model.isAnswer())
                        MainActivity.arr[position]=0;
                    else
                        MainActivity.arr[position]=1;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView q;
        RadioButton truebtn,falseBtn;
        RadioGroup group1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            group1=itemView.findViewById(R.id.radioGroup);
            truebtn=itemView.findViewById(R.id.trueButton);
            falseBtn=itemView.findViewById(R.id.falseButton);
            q=itemView.findViewById(R.id.questionText);
        }
    }
}
