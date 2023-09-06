package com.polije.sem3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.polije.sem3.min3.Latihan1;
import com.polije.sem3.min3.Latihan2;
import com.polije.sem3.min3.Tugas1;
import com.polije.sem3.min3.Tugas2;

@SuppressLint("CustomSplashScreen")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(
                this::openNew,
                1000
        );
    }

    public void openNew(){
        startActivity(new Intent(MainActivity.this, Tugas2.class));
    }
}