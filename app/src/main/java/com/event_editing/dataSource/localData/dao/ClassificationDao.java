package com.wangtianyu.event_editing.dataSource.localData.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wangtianyu.event_editing.dataSource.localData.entity.Classification;

import java.util.List;
@Dao
public interface ClassificationDao {

    @Insert
    void insertClassifications(Classification...classifications);

    @Update
    void updateClassifications(Classification...classifications);

    @Delete
    void deleteClassifications(Classification...classifications);

    @Query("SELECT * FROM CLASSIFICATION")
    LiveData<List<Classification>> getAllClassifications();

    @Query("SELECT * FROM CLASSIFICATION WHERE ID = :id ")
    LiveData<Classification> getClassificationById(Long id);

}
