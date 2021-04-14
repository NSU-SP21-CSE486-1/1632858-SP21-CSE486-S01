package com.example.sqllitemultipleactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private RecyclerView mListviewer;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;

    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mListviewer = findViewById(R.id.viewAllStudents);
        mListviewer.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mListviewer.setLayoutManager(mLayoutmanager);


        DatabaseHelper databaseHelper = new DatabaseHelper(ThirdActivity.this);
        List<StudentModel> getNames = databaseHelper.getAllNames();

        mAdapter = new RecyclerViewAdapter(getNames, ThirdActivity.this);
        mListviewer.setAdapter(mAdapter);


        mDialog = new Dialog(this);

    }

}