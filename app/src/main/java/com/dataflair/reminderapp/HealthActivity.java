package com.dataflair.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    RecyclerView health;
    ArrayList<Model>dataholder=new ArrayList<>();
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        health=findViewById(R.id.health);
        health.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Cursor cursor=new dbManager(getApplicationContext()).readallreminders();
        while (cursor.moveToNext()){
            Model model=new Model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(model);
        }

        adapter=new myAdapter(dataholder);
        health.setAdapter(adapter);
    }
}