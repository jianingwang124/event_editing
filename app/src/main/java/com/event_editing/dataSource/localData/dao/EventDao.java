package com.wangtianyu.event_editing.dataSource.localData.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wangtianyu.event_editing.dataSource.localData.entity.Event;

import java.sql.Timestamp;
import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertEvents(Event... events);

    @Update
    void updateEvents(Event... events);

    @Delete
    void deleteEvents(Event... events);


    @Query("SELECT * FROM EVENT WHERE ID = :id ")
    LiveData<Event> getEventById(Long id);


    @Query("SELECT * FROM EVENT WHERE STARTAT = :startAt")
    LiveData<List<Event>> getEventsByStartTime(Timestamp startAt);

    @Query("SELECT * FROM EVENT")
    LiveData<List<Event>> getAllEvents();

}
