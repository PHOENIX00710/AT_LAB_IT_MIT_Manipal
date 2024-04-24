package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText authorAdd,titleAdd,priceAdd;
    ArrayList<Books> bookList;
    RecyclerView r1;
    AdapterMy adp;
    DBHandler dbHandler;
    Button addBook,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorAdd=findViewById(R.id.add_author);
        titleAdd=findViewById(R.id.add_title);
        priceAdd=findViewById(R.id.add_price);

        addBook=findViewById(R.id.add_book);
        show=findViewById(R.id.showList);

        bookList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);
        // on below line passing our array list to our adapter class.
        r1 = findViewById(R.id.recyclerView);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String author=authorAdd.getText().toString();
                String title=titleAdd.getText().toString();
                String price=priceAdd.getText().toString();

                if(author.equals("") || title.equals("") || price.equals("")){
                    Toast.makeText(MainActivity.this, "Fill All details", Toast.LENGTH_SHORT).show();
                }
                else{
                    dbHandler.addNewCourse(title,author,price);
                    Toast.makeText(MainActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookList = dbHandler.readCourses();
                adp = new AdapterMy(bookList, MainActivity.this);

                // setting layout manager for our recycler view.
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                r1.setLayoutManager(linearLayoutManager);

                // setting our adapter to recycler view.
                r1.setAdapter(adp);
            }
        });
    }
}