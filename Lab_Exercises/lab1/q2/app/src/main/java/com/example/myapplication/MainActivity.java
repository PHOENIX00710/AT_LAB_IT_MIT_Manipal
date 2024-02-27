package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailText,passwordText,phoneText;

    String email,password,phone;
    Button b1;
    public boolean check() {
        if (phone.isEmpty() || email.isEmpty() || phone.length() != 10) {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!(phone.charAt(i) >= '0' && phone.charAt(i) <= '9')) {
                return false;
            }
        }
        return email.endsWith("@gmail.com");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define the input params and the button
        emailText=findViewById(R.id.email);
        passwordText=findViewById(R.id.password);
        phoneText=findViewById(R.id.phoneNumber);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get values from input
                email=emailText.getText().toString();
                password=passwordText.getText().toString();
                phone=phoneText.getText().toString();

                // Perform check and accordingly adjust
                boolean correct=check();
                String temp;
                if(correct)
                    temp="User Registered";
                else
                    temp="Error in fields entered";
                Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
            }
        });

    }
}