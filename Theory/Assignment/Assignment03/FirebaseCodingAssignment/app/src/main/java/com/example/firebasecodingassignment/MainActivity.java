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

public class MainActivity extends AppCompatActivity {
    EditText mLoginEmail;
    EditText mLoginPassword;
    FirebaseAuth uAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uAuth = FirebaseAuth.getInstance();

        mLoginEmail = findViewById(R.id.login_email_edittext);
        mLoginPassword = findViewById(R.id.login_password_edittext);
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
                    finish();
                    Intent intent = new Intent(getApplicationContext(), ViewAll.class);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "You Have No Account. Please SignUp First", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}