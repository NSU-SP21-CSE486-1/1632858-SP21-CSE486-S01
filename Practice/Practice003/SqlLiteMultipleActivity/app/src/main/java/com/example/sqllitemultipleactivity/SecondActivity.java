package com.example.sqllitemultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    AutoCompleteTextView mgenderList;
    String mAddress;
    String mName;
    EditText mNumber;
    EditText mDate;
    String print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mNumber = findViewById(R.id.phoneNumber_edittext);
        mDate = findViewById(R.id.dateOfBirth);

        //code form dropdown
        mgenderList = findViewById(R.id.gender_dropdown);
        String[] gender = getResources().getStringArray(R.array.gender_list);

        ArrayAdapter genderListArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,gender);
        genderListArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mgenderList.setAdapter(genderListArrayAdapter);

        //getting data from the first activity
        Intent intent = getIntent();
        mName = intent.getStringExtra(MainActivity.EXTRA_Name);
        mAddress = intent.getStringExtra(MainActivity.EXTRA_Address);


    }

    public void onSave(View view) {

        StudentModel studentModel;
        try{
            studentModel = new StudentModel(-1, mName, mAddress ,mgenderList.getText().toString(),Integer.parseInt(mNumber.getText().toString()),mDate.getText().toString());
            Toast.makeText(SecondActivity.this, studentModel.toString(), Toast.LENGTH_LONG).show();

        }
        catch (Exception e){
            studentModel = new StudentModel( -1,"error","Error","Error",0,"Error");
            Toast.makeText(SecondActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

        DatabaseHelper databaseHelper = new DatabaseHelper(SecondActivity.this);
        databaseHelper.addStudent(studentModel);
    }
}