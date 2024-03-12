package com.example.encrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView encryptedText;
    TextView word;
    Button encrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word=findViewById(R.id.word);
        encryptedText=findViewById(R.id.encryptedWord);
        encrypt=findViewById(R.id.button2);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=word.getText().toString();
                String ans="";
                for(int i=0;i<str.length();i++){
                    char temp=str.charAt(i);
                    temp+=3;
                    ans+=Character.toString(temp);
                }
                encryptedText.setText(ans);
            }
        });
    }
}