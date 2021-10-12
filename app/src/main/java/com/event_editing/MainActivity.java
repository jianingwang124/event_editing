package com.wangtianyu.event_editing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangtianyu.event_editing.dataSource.Repository.EventRepository;
import com.wangtianyu.event_editing.dataSource.localData.entity.Classification;
import com.wangtianyu.event_editing.dataSource.localData.entity.Event;

import java.sql.Timestamp;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
}