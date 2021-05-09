package com.example.firebasecodingassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchAllStudents extends AppCompatActivity {
    private RecyclerView mListviewer;
    private RecyclerView.LayoutManager mLayoutmanager;
    RecyclerViewAdapter mAdapter;
    EditText mSearchBar;
    CharSequence searchItem = "";


    ArrayList<StudentModel> getAllStudentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_all_students);

        DatabaseReference uDatabaseReference = FirebaseDatabase.getInstance().getReference("StudentModel");

        getAllStudentInfo = new ArrayList<>();

        mListviewer = findViewById(R.id.searchAllStudents);
        mListviewer.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mListviewer.setLayoutManager(mLayoutmanager);
        mSearchBar = findViewById(R.id.search_bar);


        mAdapter = new RecyclerViewAdapter(getAllStudentInfo, SearchAllStudents.this);
        mListviewer.setAdapter(mAdapter);

        uDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    StudentModel studentModel = dataSnapshot.getValue(StudentModel.class);
                    getAllStudentInfo.add(studentModel);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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