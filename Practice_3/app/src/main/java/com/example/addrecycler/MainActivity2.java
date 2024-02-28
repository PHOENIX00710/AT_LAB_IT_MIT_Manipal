package com.example.addrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent i;
    TextView  t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.totalAmount);
        i=getIntent();
        String str= String.valueOf(myAdapter.total);
        t1.setText("Total Amount: "+str);
    }
}