package com.example.codingassignment.uicontroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.codingassignment.R;

import java.util.Locale;

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
        loadLocale();


        uFullName = findViewById(R.id.fullName_edittext);
        uNsuID = findViewById(R.id.nsuId_edittext);
        uNsuMail = findViewById(R.id.nsuMail_edittext);
        uPhoneNumber = findViewById(R.id.phoneNumber_edittext);
        uPassword = findViewById(R.id.password_edittext);
        uConfPassword = findViewById(R.id.passwordConfrim_edittext);

    }

    public void onClickNext(View view) {
        boolean allowNext = true;
        String fullNameString = uFullName.getText().toString();
        String nsuIDString = uNsuID.getText().toString();
        String nsuMailString  = uNsuMail.getText().toString();
        String phoneNumberString = uPhoneNumber.getText().toString();
        String passwordString = uPassword.getText().toString();
        String confPasswordString = uConfPassword.getText().toString();

//        int first_digit = Integer.parseInt(phoneNumberString.substring(0,1));
        
//        char second_digit = phoneNumberString.charAt(1);
        
        if(nsuIDString.length() != 7){
            uNsuID.setError(getString(R.string.nsu_id_error_message));
            allowNext = false;
        }
        if(phoneNumberString.length() != 11){
            uPhoneNumber.setError(getString(R.string.phone_number_error_message));
            allowNext = false;
        }
//        else if(first_digit != 0){
//            uPhoneNumber.setError("The number is not valid");
//        }



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
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(USER_FULLNAME, fullNameString);
            intent.putExtra(USER_NSUID, nsuIDString);
            intent.putExtra(USER_NSUMAIL, nsuMailString);
            intent.putExtra(USER_PHONENUMBER, phoneNumberString);
            intent.putExtra(USER_PASSWORD, passwordString);

            startActivity(intent);
        }

    }


    public void getSearch(View view) {
        Intent intent = new Intent(this, SearchAllStudents.class);
        startActivity(intent);
    }

    public void changeLanguage(View view) {
        showLanguageChangeDialog();
    }

    private void showLanguageChangeDialog() {
        final String[] languageItems = {"English","বাংলা"};
        AlertDialog.Builder uBuilder = new AlertDialog.Builder(MainActivity.this);
        uBuilder.setTitle("Change Language..");

        uBuilder.setSingleChoiceItems(languageItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    setLocale("en");
                    recreate();
                }
                else if(which == 1){
                    setLocale("bn");
                    recreate();
                }

                dialog.dismiss();
            }
        });
        AlertDialog mDialog = uBuilder.create();
        mDialog.show();
    }

    private void setLocale(String language) {

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Language",language);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Language","");
        setLocale(language);
    }

    public void viewAllStudents(View view) {
        Intent intent = new Intent(this, ViewAllStudents.class);
        startActivity(intent);
    }
}