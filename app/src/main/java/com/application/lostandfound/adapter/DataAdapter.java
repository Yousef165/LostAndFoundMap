package com.application.lostandfound.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.lostandfound.MainActivity;
import com.application.lostandfound.R;
import com.application.lostandfound.model.LostAndFound;
import com.application.lostandfound.service.CreateAdvert;
import com.application.lostandfound.service.Delete;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    // variable for our array list and context
    private ArrayList<LostAndFound> LostAndFoundArrayList;
    private Context context;

    // constructor
    public DataAdapter(ArrayList<LostAndFound> LostAndFoundArrayList, Context context) {
        this.LostAndFoundArrayList = LostAndFoundArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.

        LostAndFound modal = LostAndFoundArrayList.get(position);
        holder.dataIdTV.setText(modal.get_Id());
        holder.dataNameTV.setText(modal.get_Name());
        holder.dataDescTV.setText(modal.get_Description());

        // on below line we are setting click listener for our item of recycler view.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show();
                // inside on click listener method we are calling a method to pass our data to our activity.
                Intent intent = new Intent(context, Delete.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", modal.get_Id());
                bundle.putString("name", modal.get_Name());
                bundle.putString("phone", modal.get_Phone());
                bundle.putString("description", modal.get_Description());
                bundle.putString("date", modal.get_Date());
                bundle.putString("location", modal.get_Location());
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return LostAndFoundArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView dataNameTV, dataDescTV, dataIdTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            dataNameTV = itemView.findViewById(R.id.dataName);
            dataDescTV = itemView.findViewById(R.id.dataDescription);
            dataIdTV = itemView.findViewById(R.id.dataId);
        }
    }
}