package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    Button add,populate,submit;
    ListView l1;
    ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> partyNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=findViewById(R.id.nameInput);
        add=findViewById(R.id.addButton);
        populate=findViewById(R.id.populateButton);
        submit=findViewById(R.id.submitButton);
        l1=findViewById(R.id.list1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currName=input1.getText().toString();
                Toast.makeText(MainActivity.this, currName, Toast.LENGTH_SHORT).show();
                names.add(currName);
            }
        });


        populate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> arr= new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
                l1.setAdapter(arr);
            }
        });

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=(String)l1.getItemAtPosition(position);
                partyNames.add(value);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, MainActivity2.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}