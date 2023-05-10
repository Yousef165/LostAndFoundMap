package com.application.lostandfound.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.application.lostandfound.MainActivity;
import com.application.lostandfound.R;
import com.application.lostandfound.adapter.DataAdapter;
import com.application.lostandfound.db.DBHandler;

public class Delete extends AppCompatActivity {

    private Button deleteBtn;
    private TextView dataId, dataName, dataPhone, dataDescription, dataDate, dataLocation;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteBtn = findViewById(R.id.deleteBtn);
        dataId = findViewById(R.id.dataId);
        dataName = findViewById(R.id.dataName);
        dataPhone = findViewById(R.id.dataPhone);
        dataDescription = findViewById(R.id.dataDescription);
        dataDate = findViewById(R.id.dataDate);
        dataLocation = findViewById(R.id.dataLocation);


        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("id");
        String name = bundle.getString("name");
        String phone = bundle.getString("phone");
        String description = bundle.getString("description");
        String date = bundle.getString("date");
        String location = bundle.getString("location");


        dataId.setText(id);
        dataName.setText(name);
        dataPhone.setText(phone);
        dataDescription.setText(description);
        dataDate.setText(date);
        dataLocation.setText(location);


        deleteBtn.setOnClickListener(v -> {
            dbHandler = new DBHandler(Delete.this);
            dbHandler.deleteData(id, Delete.this);
        });


    }
}