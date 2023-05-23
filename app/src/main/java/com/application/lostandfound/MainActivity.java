package com.application.lostandfound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.application.lostandfound.service.CreateAdvert;
import com.application.lostandfound.service.ShowAndFound;
import com.application.lostandfound.service.ShowOnMap;

public class MainActivity extends AppCompatActivity {

    Button createAdvertBtn, showAndFoundBtn, showOnMapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAdvertBtn = findViewById(R.id.createAdvertBtn);
        showAndFoundBtn = findViewById(R.id.showAndFoundBtn);
        showOnMapBtn = findViewById(R.id.showOnMapBtn);

        createAdvertBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateAdvert.class);
            intent.putExtra("location", "");
            intent.putExtra("latitude", "");
            intent.putExtra("longitude", "");
            startActivity(intent);
        });

        showAndFoundBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowAndFound.class);
            startActivity(intent);
        });

        showOnMapBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowOnMap.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}