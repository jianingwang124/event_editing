package com.wangtianyu.event_editing.dataSource.localData.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Classification {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    Long id;
    @NonNull
    String name;
    @NonNull
    String colorCode;

    public Classification(Long id, String name, String colorCode) {
        this.id = id;
        this.name = name;
        this.colorCode = colorCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
