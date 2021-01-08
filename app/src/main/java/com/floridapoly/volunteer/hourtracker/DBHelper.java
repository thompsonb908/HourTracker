package com.floridapoly.volunteer.hourtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "hour_tracking.db",null, 1);
    }

    public static final String TABLE_NAME = "STUDY_HOURS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_START = "START_TIME";
    public static final String COLUMN_END = "END_TIME";
    public static final String COLUMN_HOURS = "ELAPSED_HOURS";
    public static final String COLUMN_MINUTES = "ELAPSED_MINUTES";
    public static final String COLUMN_SECONDS = "ELAPSED_SECONDS";
    public static final String COLUMN_LOCATION = "LOCATION";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatTable = "CREATE TABLE " + TABLE_NAME + "("+COLUMN_ID+" integer primary key autoincrement," +
                COLUMN_START + " TEXT, " + COLUMN_END +" text, " + COLUMN_LOCATION +" integer)";
        db.execSQL(creatTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addSession(StudySession s){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_START, s.getStartTime().toString());
        cv.put(COLUMN_END, s.getEndTime().toString());
        cv.put(COLUMN_LOCATION, s.getLocation().toString());

        long success = db.insert(TABLE_NAME, null, cv);
        if (success == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<StudySession> getAllSessions() {
        List<StudySession> returnList = new ArrayList<>();

        String queryString = "SELECT * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(queryString, null);

        if(cs.moveToFirst()){
            do {
                int sessionID = cs.getInt(0);
                Date startTime = new Date(cs.getString(1));
                Date endTime = new Date(cs.getString(2));
                String location = cs.getString(3);
                StudySession studySession = new StudySession(startTime,endTime,Location.valueOf(location));
                returnList.add(studySession);
            }while(cs.moveToNext());
        }
        cs.close();
        db.close();
        return returnList;

    }
}
