package com.example.firebasecodingassignment.uicontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.firebasecodingassignment.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText uFullName;
    private EditText uNsuID;
    private EditText uNsuMail;
    private EditText uPhoneNumber;
    private EditText uPassword;
    private EditText uConfPassword;

    public static final String USER_FULLNAME = "com.example.firebasecodingassignment.extra.FULLNAME";
    public static final String USER_NSUID = "com.example.firebasecodingassignment.extra.NSUID";
    public static final String USER_NSUMAIL = "com.example.firebasecodingassignment.extra.NSUMAIL";
    public static final String USER_PHONENUMBER = "com.example.firebasecodingassignment.extra.PHONENUMBER";
    public static final String USER_PASSWORD = "com.example.firebasecodingassignment.extra.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uFullName = findViewById(R.id.fullName_edittext);
        uNsuID = findViewById(R.id.nsuId_edittext);
        uNsuMail = findViewById(R.id.nsuMail_edittext);
        uPhoneNumber = findViewById(R.id.phoneNumber_edittext);
        uPassword = findViewById(R.id.password_edittext);
        uConfPassword = findViewById(R.id.passwordConfrim_edittext);

    }


    public void onNextClick(View view) {
        boolean allowNext = true;
        String fullNameString = uFullName.getText().toString();
        String nsuIDString = uNsuID.getText().toString();
        String nsuMailString  = uNsuMail.getText().toString();
        String phoneNumberString = uPhoneNumber.getText().toString();
        String passwordString = uPassword.getText().toString();
        String confPasswordString = uConfPassword.getText().toString();

        if(nsuIDString.length() != 7){
            uNsuID.setError(getString(R.string.nsu_id_error_message));
            allowNext = false;
        }
        if(phoneNumberString.length() != 11){
            uPhoneNumber.setError(getString(R.string.phone_number_error_message));
            allowNext = false;
        }

        if(passwordString.length() == 0){
            uPassword.setError(getString(R.string.empty_password_error_message));
            allowNext = false;
        }

        if(passwordString.equals(confPasswordString)){

        }
        else{
            uConfPassword.setError(getString(R.string.cofirm_password_error_message));
            allowNext = false;
        }

        if(allowNext) {
            Intent intent = new Intent(RegisterActivity.this, SecondRegisterActivity.class);

            intent.putExtra(USER_FULLNAME, fullNameString);
            intent.putExtra(USER_NSUID, nsuIDString);
            intent.putExtra(USER_NSUMAIL, nsuMailString);
            intent.putExtra(USER_PHONENUMBER, phoneNumberString);
            intent.putExtra(USER_PASSWORD, passwordString);

            startActivity(intent);
        }

    }

    public void onRedirectLogin(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}