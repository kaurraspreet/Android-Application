package com.example.dell.meetingapp;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

//import com.example.dell.datetimeexample.R;

import java.util.Calendar;

public class Add extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    Button reminderBtn;
    ImageButton addBtn;
    EditText edTopic,edDuration;
   TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    DBHelper db=null;

   // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnDatePicker=(Button)findViewById(R.id.datebutton);
        btnTimePicker=(Button)findViewById(R.id.button3);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        reminderBtn=(Button)findViewById(R.id.button);
        addBtn=(ImageButton)findViewById(R.id.imageButton3);
        edTopic=(EditText)findViewById(R.id.editText);
        edDuration=(EditText)findViewById(R.id.editText2);
       txtDate=(TextView) findViewById(R.id.set_date);
        txtTime=(TextView) findViewById(R.id.set_time);


        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DBHelper db= new DBHelper(getApplicationContext());
                String topic= edTopic.getText().toString();
                String  duration = edDuration.getText().toString();
                String  date= txtDate.getText().toString();
                String time =txtTime.getText().toString();

                meeting mett= new meeting(0,topic,duration,date,time);
                db.addMeeting(mett);
                Toast.makeText(Add.this,"meeting is successfully added",Toast.LENGTH_LONG).show();
            }
        });

        reminderBtn.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {

               Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
               Toast.makeText(getApplicationContext(),mHour+" "+mMinute,Toast.LENGTH_LONG).show();
               intent.putExtra(AlarmClock.EXTRA_HOUR,mHour);
               intent.putExtra(AlarmClock.EXTRA_MINUTES,mMinute);
               intent.putExtra(AlarmClock.EXTRA_MESSAGE,"MEETING TIME !!!");

               startActivity(intent);


               Toast.makeText(Add.this,"reminder is successfully set",Toast.LENGTH_LONG).show();
           }
       });


    }
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }





    }
}