package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.DesignTool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText uFullName;
    private EditText uNsuID;
    private EditText uNsuMail;
    private EditText uPhoneNumber;
    private EditText uPassword;
    private EditText uConfPassword;

    public static final String USER_FULLNAME = "com.example.codingassignment.extra.FULLNAME";
    public static final String USER_NSUID = "com.example.codingassignment.extra.NSUID";
    public static final String USER_NSUMAIL = "com.example.codingassignment.extra.NSUMAIL";
    public static final String USER_PHONENUMBER = "com.example.codingassignment.extra.PHONENUMBER";
    public static final String USER_PASSWORD = "com.example.codingassignment.extra.PASSWORD";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uFullName = findViewById(R.id.fullName_edittext);
        uNsuID = findViewById(R.id.nsuId_edittext);
        uNsuMail = findViewById(R.id.nsuMail_edittext);
        uPhoneNumber = findViewById(R.id.phoneNumber_edittext);
        uPassword = findViewById(R.id.password_edittext);
        uConfPassword = findViewById(R.id.passwordConfrim_edittext);

    }

    public void clickNext(View view) {

        String fullNameString = uFullName.getText().toString();
        String nsuIDString = uNsuID.getText().toString();
        String nsuMailString  = uNsuMail.getText().toString();
        String phoneNumberString = uPhoneNumber.getText().toString();
        String passwordString = uPassword.getText().toString();
        String confPasswordString = uConfPassword.getText().toString();

        Intent intent = new Intent(this,SecondActivity.class);

        intent.putExtra(USER_FULLNAME, fullNameString);
        intent.putExtra(USER_NSUID, nsuIDString);
        intent.putExtra(USER_NSUMAIL, nsuMailString);
        intent.putExtra(USER_PHONENUMBER, phoneNumberString);
        intent.putExtra(USER_PASSWORD, passwordString);

        startActivity(intent);


//        String id = mid.getText().toString();
//        if(id.length() == 7) {
//            Intent intent = new Intent(this,SecondActivity.class);
//            startActivity(intent);
//        }
//        else{
//            mid.setError("This is not your nsu id");
//        }
    }

    public void getSearch(View view) {
        Intent intent = new Intent(this,ViewAllStudents.class);
        startActivity(intent);
    }
}