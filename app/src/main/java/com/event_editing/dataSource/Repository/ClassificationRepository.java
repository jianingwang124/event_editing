package com.wangtianyu.event_editing.dataSource.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.wangtianyu.event_editing.dataSource.localData.dao.ClassificationDao;
import com.wangtianyu.event_editing.dataSource.localData.database.EventDatabase;
import com.wangtianyu.event_editing.dataSource.localData.entity.Classification;
import com.wangtianyu.event_editing.dataSource.localData.entity.Event;

import java.util.List;

public class ClassificationRepository {

    private LiveData<List<Classification>> allClassificationsLive;
    private ClassificationDao classificationDao;
    private LiveData<Classification> selectedClassification;

    public ClassificationRepository(Context context) {

        EventDatabase eventDatabase = EventDatabase.getDatabase(context.getApplicationContext());
        ClassificationDao classificationDao = eventDatabase.getClassificationDao();
        allClassificationsLive = classificationDao.getAllClassifications();
    }

    //execute CRUD
    public void insertClassifications(Classification...classifications){ new ClassificationRepository.InsertAsyncTask(classificationDao).execute(classifications);}
    public void updateClassifications(Classification...classifications){ new ClassificationRepository.UpdateAsyncTask(classificationDao).execute(classifications);}
    public void deleteClassifications(Classification...classifications){ new ClassificationRepository.DeleteAsyncTask(classificationDao).execute(classifications);}

    LiveData<List<Classification>> getAllEvents() {
        return allClassificationsLive;
    }
    public LiveData<Classification> getEventById(Long id){
        selectedClassification = classificationDao.getClassificationById(id);
        return selectedClassification;
    }
    //execute the data operation in another thread

    static class InsertAsyncTask extends AsyncTask<Classification,Void,Void> {

        private ClassificationDao classificationDao;

        InsertAsyncTask(ClassificationDao classificationDao){
            this.classificationDao=classificationDao;
        }

        @Override
        protected Void doInBackground(Classification...classifications){
            classificationDao.insertClassifications();
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Classification,Void,Void> {

        private ClassificationDao classificationDao;

        DeleteAsyncTask(ClassificationDao classificationDao){
            this.classificationDao=classificationDao;
        }

        @Override
        protected Void doInBackground(Classification...classifications){
            classificationDao.deleteClassifications();
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Classification,Void,Void> {

        private ClassificationDao classificationDao;

        UpdateAsyncTask(ClassificationDao classificationDao){
            this.classificationDao=classificationDao;
        }

        @Override
        protected Void doInBackground(Classification...classifications){
            classificationDao.updateClassifications();
            return null;
        }
    }

}
