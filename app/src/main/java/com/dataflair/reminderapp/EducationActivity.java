package com.dataflair.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class EducationActivity extends AppCompatActivity {

    RecyclerView eduRecyclerView;
    ArrayList<Model> dataholder = new ArrayList<Model>();                                               //Array list to add reminders and display in recyclerview
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        eduRecyclerView=findViewById(R.id.eduRecyclerView);
        eduRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Cursor cursor = new dbManager(getApplicationContext()).readallreminders();    //Cursor To Load data From the database
        //Cursor cursor = new dbManager.query();

        while (cursor.moveToNext()) {
            Model model = new Model(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholder.add(model);
        }

        adapter = new myAdapter(dataholder);
        eduRecyclerView.setAdapter(adapter);
    }
}