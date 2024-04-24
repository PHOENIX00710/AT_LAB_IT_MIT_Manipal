package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText t1,t2,t3;
    Button upd,del,backBtn;

    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.updateTitle);
        t2=findViewById(R.id.updateAuthor);
        t3=findViewById(R.id.updatePrice);

        upd=findViewById(R.id.update);
        del=findViewById(R.id.delete);
        backBtn=findViewById(R.id.back);

        db= new DBHandler(MainActivity2.this);

        Intent i= getIntent();
        String title=i.getStringExtra("Title");
        String author=i.getStringExtra("Author");
        String price=i.getStringExtra("Price");

        t1.setText(title);
        t2.setText(author);
        t3.setText(price);

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle=t1.getText().toString();
                String newAuthor=t2.getText().toString();
                String newPrice=t3.getText().toString();

                db.updateCourse(title,newTitle,newAuthor,newPrice);
                Toast.makeText(MainActivity2.this, "Updated "+title, Toast.LENGTH_SHORT).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteCourse(title);
                Toast.makeText(MainActivity2.this, "Deleted "+title, Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i1);
            }
        });

    }
}