package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText task;
    Button add,populate;
    RecyclerView r1;
    myAdapter ad1;
    ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task=findViewById(R.id.task);
        add=findViewById(R.id.button1);
        populate=findViewById(R.id.button2);
        r1=findViewById(R.id.ausafRandi);
        arr=new ArrayList<>();
        ad1=new myAdapter(arr,this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task1=task.getText().toString();
                arr.add(task1);
                task.setText("");
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"ausaf");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setContentTitle("Hellloooo");
                builder.setContentText("Wake up bitch!!!!!");
                builder.setAutoCancel(true);
                builder.setPriority(NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
        populate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                r1.setAdapter(ad1);
            }
        });
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel("ausaf","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }
    public void ButtonOnClick(View v ){

    }
}