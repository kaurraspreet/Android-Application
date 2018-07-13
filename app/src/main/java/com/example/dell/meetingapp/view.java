package com.example.dell.meetingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class view extends AppCompatActivity {
  TextView viewTopic,viewDuration,viewDate,viewTime;
    private static int id;
    private ListView listView;

    private MeetingAdapter mAdapter;
   String topic,duration,date,time;
   public static int getId() {
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewTopic= findViewById(R.id.tv1);
        viewDuration= findViewById(R.id.tv2);
        viewDate= findViewById(R.id.tv3);
        viewTime= findViewById(R.id.tv4);

        listView = findViewById(R.id.add);
                ArrayList<meeting> arrayList = new ArrayList<>();
                //arrayList.add(new meeting(id));
               arrayList.add(new meeting(topic));
               arrayList.add(new meeting(duration));
                arrayList.add(new meeting(date));
                arrayList.add(new meeting(time));

                mAdapter = new MeetingAdapter(this,arrayList);
                listView.setAdapter(mAdapter);

            }
        }