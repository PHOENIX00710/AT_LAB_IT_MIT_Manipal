package com.example.addrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView r1;
    ArrayList<Item> items = new ArrayList<>();
    TextView amountInput,itemInput;
    Button add,populate,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountInput=findViewById(R.id.amount);
        itemInput=findViewById(R.id.item);
        add=findViewById(R.id.addButton);
        populate=findViewById(R.id.populateButton);
        r1=findViewById(R.id.recyclerView);
        submit=findViewById(R.id.submit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName=itemInput.getText().toString();
                String itemAmount=amountInput.getText().toString();
                items.add(new Item(itemName,itemAmount));
            }
        });

        populate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter adapter=new myAdapter(items,MainActivity.this);
                LinearLayoutManager lm= new LinearLayoutManager(MainActivity.this);
                r1.setLayoutManager(lm);
                r1.setAdapter(adapter);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}