package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText task=findViewById(R.id.name);
    Button add=findViewById(R.id.button);
    ListView l1;
    ArrayList<String> arr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr2=new ArrayList<>();
        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
               R.layout.sim ,
                arr2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task1=task.getText().toString();
                arr2.add(task1);
                l1.setAdapter(arr);
            }
        });

    }
}