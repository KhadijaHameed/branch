package com.example.javaproblems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText etORiginal, etReverse ;
    String original, reverse = ""; // Objects of String class
    Button btnCheck , btnVibrateService ;

    private void getDeviceId() {
        String android_id = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.CUPCAKE) {
            android_id = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        }

        Toast.makeText(this, "android_id= " + android_id, Toast.LENGTH_LONG).show();
        Log.d("deviceID", android_id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDeviceId();
        etORiginal = findViewById(R.id.editText);
        btnCheck = findViewById(R.id.btn_check);

        btnVibrateService = findViewById(R.id.btn_vibrate_service);
        btnVibrateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVibration = new Intent(MainActivity.this,TestVibrateService.class);
                startService(intentVibration);
            }
        });


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
                    etORiginal.setText("");
                    reverse = "";
                }
                else {
                    Toast.makeText(MainActivity.this, " not  a palindrome.", Toast.LENGTH_SHORT).show();
                    etORiginal.setText("");
                    reverse = "";
                }

            }
        });


    }
}

