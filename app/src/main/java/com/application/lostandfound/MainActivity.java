package com.application.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.application.lostandfound.service.CreateAdvert;
import com.application.lostandfound.service.ShowAndFound;

public class MainActivity extends AppCompatActivity {

    Button createAdvertBtn, showAndFoundBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAdvertBtn = findViewById(R.id.createAdvertBtn);
        showAndFoundBtn = findViewById(R.id.showAndFoundBtn);

        createAdvertBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateAdvert.class);
            startActivity(intent);
        });

        showAndFoundBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowAndFound.class);
            startActivity(intent);
        });

    }
}