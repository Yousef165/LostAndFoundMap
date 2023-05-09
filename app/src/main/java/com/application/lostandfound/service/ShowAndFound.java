package com.application.lostandfound.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.application.lostandfound.R;
import com.application.lostandfound.adapter.DataAdapter;
import com.application.lostandfound.db.DBHandler;
import com.application.lostandfound.model.LostAndFound;

import java.util.ArrayList;

public class ShowAndFound extends AppCompatActivity {

    private ArrayList<LostAndFound> dataModalArrayList;
    private DBHandler dbHandler;
    private DataAdapter dataAdapter;
    private RecyclerView dataRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_and_found);

        // initializing our all variables.
        dataModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ShowAndFound.this);

        // getting our data array
        // list from db handler class.
        dataModalArrayList = dbHandler.readDatas();

        // on below line passing our array list to our adapter class.
        dataAdapter = new DataAdapter(dataModalArrayList, ShowAndFound.this);
        dataRV = findViewById(R.id.viewData);

        dataAdapter.notifyDataSetChanged();

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowAndFound.this, RecyclerView.VERTICAL, false);
        dataRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dataRV.setAdapter(dataAdapter);
        
    }
}