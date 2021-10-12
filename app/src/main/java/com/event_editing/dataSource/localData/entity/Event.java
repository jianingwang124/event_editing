package com.wangtianyu.event_editing.dataSource.localData.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;

@Entity
public class Event {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private Long classificationId;

    private Timestamp notification;

    private Timestamp repeat;

    @NonNull
    private String title;

    private Timestamp startAt;

    private Timestamp endAt;

    private String location;

    private String description;

    public Event(Long id, Long classificationId, Timestamp notification, Timestamp repeat, String title, Timestamp startAt, Timestamp endAt, String location, String description) {
        this.id = id;
        this.classificationId = classificationId;
        this.notification = notification;
        this.repeat = repeat;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public Timestamp getNotification() {
        return notification;
    }

    public void setNotification(Timestamp notification) {
        this.notification = notification;
    }

    public Timestamp getRepeat() {
        return repeat;
    }

    public void setRepeat(Timestamp repeat) {
        this.repeat = repeat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStartAt() {return startAt; }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public Timestamp getEndAt() { return endAt; }

    public void setEndAt(Timestamp endAt) {
        this.endAt = endAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

