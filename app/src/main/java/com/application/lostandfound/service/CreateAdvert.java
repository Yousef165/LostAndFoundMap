package com.application.lostandfound.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.lostandfound.R;
import com.application.lostandfound.db.DBHandler;
import com.google.android.material.textfield.TextInputEditText;

public class CreateAdvert extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nameEdt, phoneEdt, descriptionEdt, dateEdt, locationEdt;
    private Button createAdvertBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        // initializing all our variables.
        nameEdt = findViewById(R.id.productNameEditText);
        phoneEdt = findViewById(R.id.productNumberEditText);
        descriptionEdt = findViewById(R.id.productDescriptionEditText);
        dateEdt = findViewById(R.id.productDateEditText);
        locationEdt = findViewById(R.id.productLocationEditText);
        createAdvertBtn = findViewById(R.id.createAdvertBtn);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(CreateAdvert.this);

        // adding on click listener to our button.
        createAdvertBtn.setOnClickListener(v -> {
            // getting data from edittext fields.
            String name = nameEdt.getText().toString();
            String phone = phoneEdt.getText().toString();
            String description = descriptionEdt.getText().toString();
            String date = dateEdt.getText().toString();
            String location = locationEdt.getText().toString();

            // validating if the text fields are empty or not.
            if (name.isEmpty() && phone.isEmpty() && description.isEmpty() && date.isEmpty() && location.isEmpty()) {
                // if the text fields are empty
                // then show the below message.
                nameEdt.setError("Please enter name");
                phoneEdt.setError("Please enter phone");
                descriptionEdt.setError("Please enter description");
                dateEdt.setError("Please enter date");
                locationEdt.setError("Please enter location");
            } else {
                // if the text fields are not empty
                // then call the below method.
                dbHandler.addData(name, phone, description, date, location);

                nameEdt.setText("");
                phoneEdt.setText("");
                descriptionEdt.setText("");
                dateEdt.setText("");
                locationEdt.setText("");

                // after adding the data we are displaying a toast message.
                Toast.makeText(CreateAdvert.this, "Advert has been created", Toast.LENGTH_SHORT).show();
            }
        });



    }
}