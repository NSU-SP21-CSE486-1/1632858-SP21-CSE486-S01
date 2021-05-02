package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText mName;
    EditText mAge;
    DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name_edittext);
        mAge = findViewById(R.id.age_edittext);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("UserModel");
    }


    public void onSaveClick(View view) {
        Toast.makeText(this, "it works", Toast.LENGTH_SHORT).show();
        SaveData();
    }

    private void SaveData() {
        String uName = mName.getText().toString();
        Integer uAge = Integer.parseInt(mAge.getText().toString());
        String uKey = mDatabaseReference.push().getKey();

        UserModel userModel = new UserModel(uName,uAge);
        mDatabaseReference.child(uKey).setValue(userModel);

        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void viewAllOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, ViewAll.class);
        startActivity(intent);
    }
}