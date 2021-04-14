package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class SecondActivity extends AppCompatActivity {

    private String mFullName;
    private String mNsuID;
    private String mNsuMail;
    private String mPhoneNumber;
    private String mPassword;


    private AutoCompleteTextView mSchoolNameList;
    private AutoCompleteTextView mDepartmentNameList;
    private AutoCompleteTextView mGenderList;

    private ConstraintLayout mPresentAddressExpandableView;
    private CardView mPresentAddressCardview;

    private ConstraintLayout mPermanentAddressExpandableView;
    private CardView mPermanentAddressCardview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mSchoolNameList = findViewById(R.id.schoolName_dropdown);
        mDepartmentNameList = findViewById(R.id.depName_dropdown);
        mGenderList = findViewById(R.id.gender_dropdown);

        mPresentAddressExpandableView = findViewById(R.id.expandable_present_address);
        mPresentAddressCardview = findViewById(R.id.presentAddress_expandableMenu);

        mPermanentAddressExpandableView = findViewById(R.id.expandable_permanent_address);
        mPermanentAddressCardview = findViewById(R.id.permanentAddress_expandableMenu);

        String[] schoolNameList = getResources().getStringArray(R.array.school_name);

        String[] depName1List = getResources().getStringArray(R.array.depName_1);
        String[] depName2List = getResources().getStringArray(R.array.depName_2);
        String[] depName3List = getResources().getStringArray(R.array.depName_3);

        String[] genderList = getResources().getStringArray(R.array.gender_list);

        ArrayAdapter schoolNameAdapter = new ArrayAdapter(this, simple_list_item_1, schoolNameList);

        ArrayAdapter depName1Adapter = new ArrayAdapter(this, simple_list_item_1, depName1List);
        ArrayAdapter depName2Adapter = new ArrayAdapter(this, simple_list_item_1, depName2List);
        ArrayAdapter depName3Adapter = new ArrayAdapter(this, simple_list_item_1, depName3List);

        ArrayAdapter genderAdapter = new ArrayAdapter(this, simple_list_item_1, genderList);

        mSchoolNameList.setAdapter(schoolNameAdapter);
        mGenderList.setAdapter(genderAdapter);
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


        
        Intent intent = getIntent();

        mFullName = intent.getStringExtra(MainActivity.USER_FULLNAME);
        mNsuID = intent.getStringExtra(MainActivity.USER_NSUID);
        mNsuMail = intent.getStringExtra(MainActivity.USER_NSUMAIL);
        mPhoneNumber = intent.getStringExtra(MainActivity.USER_PHONENUMBER);
        mPassword = intent.getStringExtra(MainActivity.USER_PASSWORD);




    }

    public void expandPresentAddress(View view) {
        if (mPresentAddressExpandableView.getVisibility()==View.GONE){

            TransitionManager.beginDelayedTransition(mPresentAddressCardview, new AutoTransition());
            mPresentAddressExpandableView.setVisibility(View.VISIBLE);
        }
        else {
            TransitionManager.beginDelayedTransition(mPresentAddressCardview, new AutoTransition());
            mPresentAddressExpandableView.setVisibility(View.GONE);
        }
    }

    public void save(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void expandPermanentAddress(View view) {
        if (mPermanentAddressExpandableView.getVisibility()==View.GONE){

            TransitionManager.beginDelayedTransition(mPermanentAddressCardview, new AutoTransition());
            mPermanentAddressExpandableView.setVisibility(View.VISIBLE);
        }
        else {
            TransitionManager.beginDelayedTransition(mPermanentAddressCardview, new AutoTransition());
            mPermanentAddressExpandableView.setVisibility(View.GONE);
        }
    }
}