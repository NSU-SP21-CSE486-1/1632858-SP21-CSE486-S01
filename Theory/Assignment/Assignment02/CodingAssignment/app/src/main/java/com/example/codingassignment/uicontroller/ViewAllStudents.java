package com.example.codingassignment.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.codingassignment.room.database.DataBaseHelper;
import com.example.codingassignment.R;
import com.example.codingassignment.adapter.RecyclerViewAdapter;
import com.example.codingassignment.model.StudentModel;

import java.util.List;

public class ViewAllStudents extends AppCompatActivity {
    private RecyclerView mListviewer;
    private RecyclerView.LayoutManager mLayoutmanager;
    RecyclerViewAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);
        DataBaseHelper dataBaseHelper = Room.databaseBuilder(ViewAllStudents.this,DataBaseHelper.class,"StudentInfodb").allowMainThreadQueries().build();
        List<StudentModel> getAllStudentsInfo = dataBaseHelper.daoQuery().getAllStudents();

        mListviewer = findViewById(R.id.viewAllStudents);
        mListviewer.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mListviewer.setLayoutManager(mLayoutmanager);

        mAdapter = new RecyclerViewAdapter(getAllStudentsInfo, ViewAllStudents.this);
        mListviewer.setAdapter(mAdapter);
    }
}