package com.example.dell.meetingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.IdentityHashMap;

public class DBHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "MEETING.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "meeting";
    static final String KEY_ID = "Id";
    static final String MEETING_TOPIC = "topic";
    static final String MEETING_DURATION = "duration";
    static final String MEETING_DATE = "date";
    static final String MEETING_TIME = "time";

    // static final String MEETING_REMINDER = "reminder";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //onCreate function
    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + MEETING_TOPIC + "TEXT," + MEETING_DURATION + "TEXT," + MEETING_TIME + "TEXT" + MEETING_DATE + "TEXT" + ")";
        db.execSQL(QUERY);
    }


    //onUpgrade function
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    //getCount function
    public int getCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        String count = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(count, null);
        return cursor.getCount();
    }

    //add data into database
    public void addMeeting(meeting mett) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MEETING_TOPIC, mett.getTopic());
        cv.put(MEETING_DURATION, mett.getDuration());
        cv.put(MEETING_DATE, mett.getDate());
        cv.put(MEETING_TIME, mett.getTime());
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    public meeting getMeeting(int Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        meeting mett=null;
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME +  "where "+ Id + "=?",new String[]{Id+ ""}) ;
        if (cursor != null) {
            cursor.moveToFirst();
            mett = new meeting(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        }
         return mett;

    }
    public  Cursor fetchData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String str= ("SELECT * FROM TABLE_NAME");
        return db.rawQuery(str,null);
    }
    public void deleteTask(String s1){
        SQLiteDatabase db=this.getWritableDatabase();
       // db.execSQL("DELETE FROM +"TABLE_NAME + "WHERE" +);
        db.close();
    }

}
