package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;

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

    private String fullName;
    private String nsuID;
    private String nsuMail;
    private String phoneNumber;
    private String password;

    private AutoCompleteTextView uSchoolName;
    private AutoCompleteTextView uDepName;
    private EditText uDateOfBirth;
    private EditText uNIDNumber;
    private AutoCompleteTextView uGender;

    private EditText uPresentCountry;
    private EditText uPresentDistrict;
    private EditText uPresentPostOffice;
    private EditText uPresentPoliceStation;
    private EditText uPresentPostalCode;
    private EditText uPresentHouse;
    private EditText uPresentRoad;

    private EditText uPermanentCountry;
    private EditText uPermanentDistrict;
    private EditText uPermanentPostOffice;
    private EditText uPermanentPoliceStation;
    private EditText uPermanentPostalCode;
    private EditText uPermanentHouse;
    private EditText uPermanentRoad;


    private ConstraintLayout mPresentAddressExpandableView;
    private CardView mPresentAddressCardview;

    private ConstraintLayout mPermanentAddressExpandableView;
    private CardView mPermanentAddressCardview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        uSchoolName = findViewById(R.id.schoolName_dropdown);
        uDepName = findViewById(R.id.depName_dropdown);
        uDateOfBirth = findViewById(R.id.dateOfBirth_edittext);
        uNIDNumber = findViewById(R.id.nidNumber_edittext);
        uGender = findViewById(R.id.gender_dropdown);

        uPresentCountry = findViewById(R.id.present_address_country);
        uPresentDistrict = findViewById(R.id.present_address_district);
        uPresentPostOffice = findViewById(R.id.present_address_postOffice);
        uPresentPoliceStation = findViewById(R.id.present_address_policeStation);
        uPresentPostalCode = findViewById(R.id.present_address_postalCode);
        uPresentHouse = findViewById(R.id.present_address_house);
        uPresentRoad = findViewById(R.id.present_address_road);

        uPermanentCountry = findViewById(R.id.permanent_address_country);
        uPermanentDistrict = findViewById(R.id.permanent_address_district);
        uPermanentPostOffice = findViewById(R.id.permanent_address_postOffice);
        uPermanentPoliceStation = findViewById(R.id.permanent_address_policeStation);
        uPermanentPostalCode = findViewById(R.id.permanent_address_postalCode);
        uPermanentHouse = findViewById(R.id.permanent_address_house);
        uPermanentRoad = findViewById(R.id.permanent_address_road);

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

        uSchoolName.setAdapter(schoolNameAdapter);
        uGender.setAdapter(genderAdapter);
        uSchoolName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    uDepName.setAdapter(depName1Adapter);
                }
                else if(position ==1){
                    uDepName.setAdapter(depName2Adapter);
                }
                else{
                    uDepName.setAdapter(depName3Adapter);
                }
            }
        });



        Intent intent = getIntent();

        fullName = intent.getStringExtra(MainActivity.USER_FULLNAME);
        nsuID = intent.getStringExtra(MainActivity.USER_NSUID);
        nsuMail = intent.getStringExtra(MainActivity.USER_NSUMAIL);
        phoneNumber = intent.getStringExtra(MainActivity.USER_PHONENUMBER);
        password = intent.getStringExtra(MainActivity.USER_PASSWORD);

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

    public void save(View view) {
        String schoolName = uSchoolName.getText().toString();
        String departmentName = uDepName.getText().toString();
        String dob = uDateOfBirth.getText().toString();
        int NID = Integer.parseInt(uNIDNumber.getText().toString());
        String gender = uGender.getText().toString();

        String presentCountry = uPresentCountry.getText().toString();
        String presentDistrict = uPresentDistrict.getText().toString();
        String presentPostOffice = uPresentPostOffice.getText().toString();
        String presentPoliceStation = uPresentPoliceStation.getText().toString();
        String presentPostalCode = uPresentPostalCode.getText().toString();
        String presentHouse = uPresentHouse.getText().toString();
        String presentRoad = uPresentRoad.getText().toString();

        String permanentCountry = uPermanentCountry.getText().toString();
        String permanentDistrict = uPermanentDistrict.getText().toString();
        String permanentPostOffice = uPermanentPostOffice.getText().toString();
        String permanentPoliceStation = uPermanentPoliceStation.getText().toString();
        String permanentPostalCode = uPermanentPostalCode.getText().toString();
        String permanentHouse = uPermanentHouse.getText().toString();
        String permanentRoad = uPermanentRoad.getText().toString();

        String presentAddress = "House: " + presentHouse +
                ", Road: " + presentRoad +
                ", Police Station: " + presentPoliceStation +
                ", Post Office: " + presentPostOffice +
                ", Postal Code: " + presentPostalCode +
                ", District: " + presentDistrict +
                ", Country: " + presentCountry;

        String permanentAddress = "House: " + permanentHouse +
                ", Road: " + permanentRoad +
                ", Police Station: " + permanentPoliceStation +
                ", Post Office: " + permanentPostOffice +
                ", Postal Code: " + permanentPostalCode +
                ", District: " + permanentDistrict +
                ", Country: " + permanentCountry;

        StudentModel studentModel;
        try{
            studentModel = new StudentModel(fullName,Integer.parseInt(nsuID),nsuMail,Integer.parseInt(phoneNumber),password,schoolName,departmentName,dob,NID,gender,presentAddress,permanentAddress);
//            Toast.makeText(SecondActivity.this, studentModel.toString(), Toast.LENGTH_LONG).show();
            DataBaseHelper dataBaseHelper = Room.databaseBuilder(SecondActivity.this,DataBaseHelper.class,"StudentInfodb").allowMainThreadQueries().build();

            dataBaseHelper.daoQuery().insert(studentModel);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


    }
}