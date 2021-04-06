package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

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
        String[] depName1List = getResources().getStringArray(R.array.depName_1);
        String[] depName2List = getResources().getStringArray(R.array.depName_2);
        String[] depName3List = getResources().getStringArray(R.array.depName_3);


        ArrayAdapter schoolNameAdapter = new ArrayAdapter(this, simple_list_item_1, schoolNameList);
        ArrayAdapter depName1Adapter = new ArrayAdapter(this, simple_list_item_1, depName1List);
        ArrayAdapter depName2Adapter = new ArrayAdapter(this, simple_list_item_1, depName2List);
        ArrayAdapter depName3Adapter = new ArrayAdapter(this, simple_list_item_1, depName3List);

        mSchoolNameList.setAdapter(schoolNameAdapter);

        mSchoolNameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    mDepartmentNameList.setAdapter(depName1Adapter);
                }
                else if(position ==1){
                    mDepartmentNameList.setAdapter(depName2Adapter);
                }
                else{
                    mDepartmentNameList.setAdapter(depName3Adapter);
                }
            }
        });




    }
}