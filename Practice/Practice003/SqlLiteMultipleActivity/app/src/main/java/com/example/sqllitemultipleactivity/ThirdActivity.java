package com.example.sqllitemultipleactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    RecyclerView mListviewer;
    ArrayAdapter<StudentModel> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mListviewer = findViewById(R.id.viewAllStudents);
        mListviewer.setLayoutManager(new LinearLayoutManager(this));


        DatabaseHelper databaseHelper = new DatabaseHelper(ThirdActivity.this);
        List<StudentModel> getNames = databaseHelper.getAllNames();


        Adapter = new ArrayAdapter<StudentModel>(ThirdActivity.this, android.R.layout.simple_list_item_1, getNames);
        mListviewer.setAdapter(Adapter);
    }
}