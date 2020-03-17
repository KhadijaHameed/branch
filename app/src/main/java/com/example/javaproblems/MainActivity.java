package com.example.javaproblems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText etORiginal, etReverse ;
    String original, reverse = ""; // Objects of String class
    Button btnCheck ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etORiginal = findViewById(R.id.editText);
        btnCheck = findViewById(R.id.btn_check);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etORiginal.getText().toString();
                // this line is for second branch
                int length = input.length();
                for ( int i =length- 1; i >= 0; i-- )
                    reverse = reverse + input.charAt(i);

                if (input.equals(reverse)){
                    Toast.makeText(MainActivity.this, "Entered string/number is a palindrome.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "orginial "+input+" reverse "+reverse, Toast.LENGTH_SHORT).show();
                    etORiginal.setText("");
                    reverse = "";
                }
                else {
                    Toast.makeText(MainActivity.this, "orginial "+input+" reverse "+reverse, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, " noooot  a palindrome.", Toast.LENGTH_SHORT).show();
                    etORiginal.setText("");
                    reverse = "";
                }

            }
        });

    }
}

