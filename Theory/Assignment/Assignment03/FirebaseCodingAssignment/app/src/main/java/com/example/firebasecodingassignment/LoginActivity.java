package com.example.firebasecodingassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText mLoginEmail;
    EditText mLoginPassword;
    FirebaseAuth uAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
            mLoginEmail.setError("Please enter a valid email address");
            mLoginEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mLoginEmail.setError("Please enter a valid email address");
            mLoginEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            mLoginPassword.setError("Password cannot be empty");
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
                    Toast.makeText(getApplicationContext(), "You Have No Account. Please SignUp First", Toast.LENGTH_SHORT).show();
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
}