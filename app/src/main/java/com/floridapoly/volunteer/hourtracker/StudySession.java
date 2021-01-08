package com.floridapoly.volunteer.hourtracker;

import android.os.Build;
import android.widget.Toast;

import java.time.Duration;
import java.util.Date;

public class StudySession {
    private int id;
    private Date startTime;
    private Date endTime;
    private long elapsedHours;
    private long elapsedMinutes;
    private long elapsedSeconds;
    private Location location;

    private static final long secondInMillis = 1000;
    private static final long minuteInMillis = secondInMillis * 60;
    private static final long hourInMillis = minuteInMillis * 60;
    private static final long dayInMillis = hourInMillis * 24;

    public StudySession(){
    }

    public StudySession(Date startTime, Date endTime, Location location) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        long diff = endTime.getTime() - startTime.getTime();

        long elapsedDays = diff / dayInMillis;
        diff = diff % dayInMillis;
        this.elapsedHours = diff / hourInMillis;
        diff = diff % hourInMillis;
        this.elapsedMinutes = diff / minuteInMillis;
        diff = diff % minuteInMillis;
        this.elapsedSeconds = diff / secondInMillis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getElapsedHours() {
        return elapsedHours;
    }

    public long getElapsedMinutes() {
        return elapsedMinutes;
    }

    public long getElapsedSeconds() {
        return elapsedSeconds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
