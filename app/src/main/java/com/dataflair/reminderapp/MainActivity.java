package com.dataflair.reminderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    Button Education,Finance,Health,Other,Daily,Event;
    FloatingActionButton create;
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
        create=findViewById(R.id.add_btn);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReminderActivity.class);
                startActivity(intent);
            }
        });

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
        startActivity(intent);
    }

    public void openFinance(){
        Intent intent=new Intent(this,FinanceActivity.class);
        startActivity(intent);
    }

    public void openEvent(){
        Intent intent=new Intent(this,EventActivity.class);
        startActivity(intent);
    }

    public void openOther(){
        Intent intent=new Intent(this,OtherActivity.class);
        startActivity(intent);
    }

    public void openHealth(){
        Intent intent=new Intent(this,HealthActivity.class);
        startActivity(intent);
    }

    public void openDaily(){
        Intent intent=new Intent(this,DailyActivity.class);
        startActivity(intent);
    }

}