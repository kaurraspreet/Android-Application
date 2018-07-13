package com.example.dell.meetingapp;

import android.widget.TextView;

public class meeting {
    int Id;
    String topic;
    String duration;
   // String reminder;
    String date;
    String time;

    public meeting(int id, String topic, String duration,String date, String time){
        this.Id=id;
        this.topic=topic;
        this.duration=duration;
       // this.reminder=reminder;
        this.date = date;
        this.time = time;

    }

    public meeting(int id) {
        this.Id=id;
    }

    public meeting(String viewTopic) {

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        }


}
