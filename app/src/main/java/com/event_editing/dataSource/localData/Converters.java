package com.wangtianyu.event_editing.dataSource.localData;

import androidx.room.TypeConverter;

import java.sql.Timestamp;

public class Converters {

    @TypeConverter
    public static Timestamp fromTimestamp(Long value) {
        return value == null ? null : new Timestamp(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Timestamp time) {
        return time == null ? null : time.getTime();
    }
}
