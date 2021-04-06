package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private AutoCompleteTextView mSchoolNameList;
    private AutoCompleteTextView mDepartmentNameList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSchoolNameList = findViewById(R.id.school_name_view);
        mDepartmentNameList = findViewById(R.id.dep_name_list);

        String[] schoolNameList = getResources().getStringArray(R.array.school_name);
        String[] depNameList = getResources().getStringArray(R.array.depName_1);


        ArrayAdapter schoolNameAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, schoolNameList);



        ArrayAdapter depNameAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, depNameList);
        mSchoolNameList.setAdapter(schoolNameAdapter);
        mDepartmentNameList.setAdapter(depNameAdapter);

        String SchoolName = mSchoolNameList.getText().toString();

        Toast toast = Toast.makeText(this, SchoolName, Toast.LENGTH_SHORT);
        toast.show();

    }
}