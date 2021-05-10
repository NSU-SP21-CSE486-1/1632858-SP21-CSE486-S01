package com.example.firebasecodingassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    EditText mLoginEmail;
    EditText mLoginPassword;
    FirebaseAuth uAuth;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadLocale();

        uAuth = FirebaseAuth.getInstance();

        mLoginEmail = findViewById(R.id.login_email_edittext);
        mLoginPassword = findViewById(R.id.login_password_edittext);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkSession();
    }

    private void checkSession() {
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        String userEmail = sessionManagement.getSession();

        if(userEmail != ""){
            moveToMainActivity();
        }
        else{
            //do nothing
        }
    }

    public void onLoginClick(View view) {
        String email = mLoginEmail.getText().toString();
        String password = mLoginPassword.getText().toString();

        if (email.isEmpty()) {
            mLoginEmail.setError(getString(R.string.error_email));
            mLoginEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mLoginEmail.setError(getString(R.string.error_email));
            mLoginEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            mLoginPassword.setError(getString(R.string.empty_password_error_message));
            mLoginPassword.requestFocus();
            return;
        }

        uAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    UserSession userSession = new UserSession(email,password);
                    SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
                    sessionManagement.saveSession(userSession);
                    finish();
                    moveToMainActivity();

                } else {
                    Toast.makeText(getApplicationContext(), R.string.error_account, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void moveToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onRegisterClick(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void changeLanguage(View view) {
        showLanguageChangeDialog();
    }

    private void showLanguageChangeDialog() {
        final String[] languageItems = {"English","বাংলা"};
        AlertDialog.Builder uBuilder = new AlertDialog.Builder(LoginActivity.this);
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
        editor.putString("My_Language",language).commit();
    }

    public void loadLocale(){
        prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Language","");
        if(language != ""){
            setLocale(language);
        }
        else{
            //do nothing
        }
    }
}