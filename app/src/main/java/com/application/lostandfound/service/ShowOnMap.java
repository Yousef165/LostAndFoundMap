package com.application.lostandfound.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

import com.application.lostandfound.R;
import com.application.lostandfound.db.DBHandler;
import com.application.lostandfound.model.Location;
import com.application.lostandfound.model.LostAndFound;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ShowOnMap extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private FusedLocationProviderClient fusedLocationClient;
    private ArrayList<LostAndFound> LostAndFoundArrayList;
    private MapView mapView;
    private ArrayList<LostAndFound> dataModalArrayList;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_on_map);


        // initializing all our variables.
        mapView = findViewById(R.id.mapView);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        dbHandler = new DBHandler(this);

        // Initialize the map view
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {

        dbHandler = new DBHandler(ShowOnMap.this);
        googleMap = map;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(37.4219983, -122.084)));
        //Retrieve latitude and longitude data from SQLite

        List<LatLng> locations = dbHandler.getLocations();

        //  Add markers to the map
        for (LatLng location : locations) {
            System.out.println("Location: 1111111" + location);
            googleMap.addMarker(new MarkerOptions().position(location))
                    .setTitle("Lost and Found Item");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


}