package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Quiz> q1;
    RecyclerView r1;
    static int answers[]=new int[]{-1,-1,-1,-1,-1,-1,-1};
    double score;
    int attempted;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1=new ArrayList<>();
        q1.add(new Quiz("Main chutiya hoon",true));
        q1.add(new Quiz("Meri placement lagegi",false));
        q1.add(new Quiz("Mereko Internship Mil raha",false));
        q1.add(new Quiz("Main kaam karte rahunga",true));

        r1=findViewById(R.id.questions);
        b=findViewById(R.id.submitButton);

        myAdapter ad= new myAdapter(q1,this);
        LinearLayoutManager lm= new LinearLayoutManager(MainActivity.this);

        r1.setAdapter(ad);
        r1.setLayoutManager(lm);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempted=0;
                score=0;
                for(int i=0;i<answers.length;i++){
                    if(answers[i] == -1){
                        continue;
                    }
                    if(answers[i] == 1)
                        score++;
                    else
                        score-=0.5;
                    attempted++;
                }
                Toast.makeText(MainActivity.this, "Attempted: "+attempted+" Score: "+score, Toast.LENGTH_SHORT).show();
            }
        });
    }
}