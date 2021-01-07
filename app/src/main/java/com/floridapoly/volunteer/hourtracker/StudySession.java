package com.floridapoly.volunteer.hourtracker;

import android.os.Build;
import android.widget.Toast;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class StudySession {
    private int id;
    private Instant startTime;
    private Instant endTime;
    private Date date;
    private Duration elapsedTime;
    private Location location;

    public StudySession(){
    }

    public StudySession(int id, Instant startTime, Instant endTime, Date date, Location location) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.elapsedTime = Duration.between(startTime, endTime);
        }
        this.location = location;
    }

    public StudySession(int id, Instant startTime, Date date, Location location) {
        this.id = id;
        this.startTime = startTime;
        this.date = date;
        this.location = location;
    }

    public StudySession(int id, Instant startTime, Date date) {
        this.id = id;
        this.startTime = startTime;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getElapsedTime() {
        return elapsedTime;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

}
