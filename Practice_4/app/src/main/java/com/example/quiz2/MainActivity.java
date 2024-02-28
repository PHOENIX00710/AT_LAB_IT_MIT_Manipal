package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Question> q2=new ArrayList<>();
    static int arr[]=new int[]{-1,-1,-1,-1,-1};
    static int attempted=0;
    static double score=0;
    Button submit;
    RecyclerView r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=findViewById(R.id.recyclerView);
        submit=findViewById(R.id.submit);

        q2.add(new Question("Main chutiya hoon",true));
        q2.add(new Question("Meri placement hogi",false));
        q2.add(new Question("Meri internship lagegi",false));
        q2.add(new Question("Main kam toh karunga",true));
        myAdapter adapter=new myAdapter(q2,this);
        LinearLayoutManager lm=new LinearLayoutManager(this);
        r1.setAdapter(adapter);
        r1.setLayoutManager(lm);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempted=0;
                score=0;
                for(int i=0;i<q2.size();i++){
                    if(arr[i] == -1)
                        continue;
                    if(arr[i] == 1)
                        score+=1;
                    if(arr[i] == 0)
                        score-=0.5;
                    attempted++;
                }
                Toast.makeText(MainActivity.this, "Attempted: "+attempted+" Score: "+score, Toast.LENGTH_SHORT).show();
            }
        });

    }
}