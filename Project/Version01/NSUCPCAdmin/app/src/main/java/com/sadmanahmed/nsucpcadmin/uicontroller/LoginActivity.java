package com.sadmanahmed.nsucpcadmin.uicontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sadmanahmed.nsucpcadmin.R;
import com.sadmanahmed.nsucpcadmin.session.SessionManagement;
import com.sadmanahmed.nsucpcadmin.session.UserSession;
import com.sadmanahmed.nsucpcadmin.permissions.AndroidRunTimePermissions;

import java.lang.ref.WeakReference;

public class LoginActivity extends AppCompatActivity {
    // declaring necessary variables
    Window window;

    EditText mLoginEmail;
    EditText mLoginPassword;
    FirebaseAuth uAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkForRuntimePermissions();

        //set status bar color
        if(Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        // login authentication
        uAuth = FirebaseAuth.getInstance();

        mLoginEmail = findViewById(R.id.login_email_edittext);
        mLoginPassword = findViewById(R.id.login_password_edittext);
    }

    private void checkForRuntimePermissions() {
        new AndroidRunTimePermissions(new WeakReference<Activity>(this)).checkForPermissions();
    }

    public void onLoginBtnClick(View view) {
        //checking the login authentication
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
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }


}