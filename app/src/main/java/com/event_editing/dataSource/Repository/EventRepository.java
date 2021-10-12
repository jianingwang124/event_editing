package com.wangtianyu.event_editing.dataSource.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.wangtianyu.event_editing.dataSource.localData.dao.EventDao;
import com.wangtianyu.event_editing.dataSource.localData.database.EventDatabase;
import com.wangtianyu.event_editing.dataSource.localData.entity.Event;

import java.util.List;

public class EventRepository {
    private LiveData<List<Event>> allEventsLive;
    private LiveData<Event> selectedEvent;
    private EventDao eventDao;

    public EventRepository(Context context) {
        EventDatabase eventDatabase = EventDatabase.getDatabase(context.getApplicationContext());
        eventDao = eventDatabase.getEventDao();
        allEventsLive = eventDao.getAllEvents();

    }

    public void insertEvents(Event... events) {
        new InsertAsyncTask(eventDao).execute(events);
    }

    public void updateEvents(Event... events) { new UpdateAsyncTask(eventDao).execute(events); }

    public void deleteEvents(Event... events) {
        new DeleteAsyncTask(eventDao).execute(events);
    }


    public LiveData<Event> getEventById(Long id){
        selectedEvent = eventDao.getEventById(id);
        return selectedEvent;
    }

    public LiveData<List<Event>> getAllEvents() {
        return allEventsLive;
    }

    static class InsertAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao eventDao;

        InsertAsyncTask(EventDao wordDao) {
            this.eventDao = wordDao;
        }

        @Override
        protected Void doInBackground(Event... words) {
            eventDao.insertEvents(words);
            return null;
        }

    }

    static class UpdateAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao eventDao;

        UpdateAsyncTask(EventDao wordDao) {
            this.eventDao = wordDao;
        }

        @Override
        protected Void doInBackground(Event... events) {
            eventDao.updateEvents(events);
            return null;
        }

    }

    static class DeleteAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao eventDao;

        DeleteAsyncTask(EventDao eventDao) {
            this.eventDao = eventDao;
        }

        @Override
        protected Void doInBackground(Event... events) {
            eventDao.deleteEvents(events);
            return null;
        }

    }


}
