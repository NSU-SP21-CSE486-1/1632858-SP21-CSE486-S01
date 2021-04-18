package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.List;

public class SearchAllStudents extends AppCompatActivity {
    private RecyclerView mListviewer;
    private RecyclerView.LayoutManager mLayoutmanager;
    RecyclerViewAdapter mAdapter;
    EditText mSearchBar;
    CharSequence searchItem = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all_students);
        DataBaseHelper dataBaseHelper = Room.databaseBuilder(SearchAllStudents.this,DataBaseHelper.class,"StudentInfodb").allowMainThreadQueries().build();
        List<StudentModel> getAllStudentsInfo = dataBaseHelper.daoQuery().getAllStudents();

        mListviewer = findViewById(R.id.searchAllStudents);
        mListviewer.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mListviewer.setLayoutManager(mLayoutmanager);
        mSearchBar = findViewById(R.id.search_bar);


        mAdapter = new RecyclerViewAdapter(getAllStudentsInfo, SearchAllStudents.this);
        mListviewer.setAdapter(mAdapter);

        mSearchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                mAdapter.getSearchFilter().filter(charSequence);
                searchItem = charSequence;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}