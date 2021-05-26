package com.sadmanahmed.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LoginActivity extends AppCompatActivity {
    EditText mLoginEmail;
    EditText mLoginPassword;
    FirebaseAuth uAuth;
    FirebaseDatabase database;
    DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabaseReference = database.getReference("StudentModel");

        mLoginEmail = findViewById(R.id.login_email_edittext);
        mLoginPassword = findViewById(R.id.login_password_edittext);

    }

    public void onRegisterClick(View view) {
        Intent intent = new Intent(LoginActivity.this, FirstRegisterActivity.class);
        startActivity(intent);
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
                    moveToMainActivity(email);

                } else {
                    Toast.makeText(getApplicationContext(), R.string.error_account, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void moveToMainActivity(String email) {
        Query query = database.getReference("StudentModel").child("nsuMail").equalTo(email);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}