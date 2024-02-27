package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView l1;
    ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("item1", "item2","item3","item4"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1=findViewById(R.id.listview1);
        ArrayAdapter<String> arr=new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr1);
        l1.setAdapter(arr);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value= (String) l1.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Position: "+position+" Value: "+value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}