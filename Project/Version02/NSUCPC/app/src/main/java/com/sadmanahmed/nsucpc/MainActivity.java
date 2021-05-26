package com.sadmanahmed.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mListviewer;
    private RecyclerView.LayoutManager mLayoutmanager;
    RecyclerViewAdapter mAdapter;

    FirebaseDatabase database;
    private DatabaseReference uDatabaseReference;
    ArrayList<JobModel> getAlLJobs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListviewer = findViewById(R.id.jobList_recyclerview);
        mListviewer.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mListviewer.setLayoutManager(mLayoutmanager);

        database = FirebaseDatabase.getInstance();
        uDatabaseReference = database.getReference("JobModel");

        getAlLJobs = new ArrayList<>();

        mAdapter = new RecyclerViewAdapter(getAlLJobs, this);
        mListviewer.setAdapter(mAdapter);

        uDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    JobModel jobModel = dataSnapshot.getValue(JobModel.class);
                    getAlLJobs.add(jobModel);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void inLogoutClick(View view) {
        FirebaseAuth.getInstance().signOut();
        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        sessionManagement.removeSession();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}