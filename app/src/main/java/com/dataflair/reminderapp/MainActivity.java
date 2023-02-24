package com.dataflair.reminderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button Education,Finance,Health,Other,Daily,Event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Education=findViewById(R.id.edu_btn);
        Event=findViewById(R.id.event_btn);
        Health=findViewById(R.id.health_btn);
        Finance=findViewById(R.id.finance_btn);
        Daily=findViewById(R.id.routine_btn);
        Other=findViewById(R.id.other_btn);

        Education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEducation();
            }
        });

        Finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFinance();
            }
        });

        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealth();
            }
        });

        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOther();
            }
        });

        Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEvent();
            }
        });

        Daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDaily();
            }
        });
    }

    public void openEducation(){
        Intent intent=new Intent(this,EducationActivity.class);
    }

    public void openFinance(){}

    public void openEvent(){}

    public void openOther(){}

    public void openHealth(){}

    public void openDaily(){}

}