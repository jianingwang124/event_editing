package com.wangtianyu.event_editing.dataSource.localData.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.wangtianyu.event_editing.dataSource.localData.Converters;
import com.wangtianyu.event_editing.dataSource.localData.dao.ClassificationDao;
import com.wangtianyu.event_editing.dataSource.localData.dao.EventDao;
import com.wangtianyu.event_editing.dataSource.localData.entity.Classification;
import com.wangtianyu.event_editing.dataSource.localData.entity.Event;


@Database(entities = {Event.class, Classification.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class EventDatabase extends RoomDatabase {

    //Singleton
    private static EventDatabase INSTANCE;
    public static synchronized EventDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class, "event_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract EventDao getEventDao() ;
    public abstract ClassificationDao getClassificationDao();
}
