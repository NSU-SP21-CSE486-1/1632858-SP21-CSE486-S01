package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView mschoolname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mschoolname = findViewById(R.id.autoCompleteTextView);
        String[] names = getResources().getStringArray(R.array.dropdown_list);

        ArrayAdapter namesAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names);
        namesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mschoolname.setAdapter(namesAdapter);

        String schoolname = mschoolname.getText().toString();


        Toast toast = Toast.makeText(this, schoolname, Toast.LENGTH_SHORT);
        toast.show();

//        mSchoolNameSpinner = findViewById(R.id.school_name_spinner);
//
//        String[] schoolNameList = getResources().getStringArray(R.array.school_name_list);
//        ArrayAdapter schoolNameAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, schoolNameList);
//        schoolNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        mSchoolNameSpinner.setAdapter(schoolNameAdapter);
    }
}