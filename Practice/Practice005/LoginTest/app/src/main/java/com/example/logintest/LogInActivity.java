package com.example.logintest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText loginEmail, loginpassword;
    private TextView dontAccount;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Log In Activity");

        mAuth = FirebaseAuth.getInstance();
//        SessionManagement sessionManagement = new SessionManagement(LogInActivity.this);

        loginButton = findViewById(R.id.loginButtonId);
        loginEmail = findViewById(R.id.loginEmailId);
        loginpassword = findViewById(R.id.loginPasswordId);
        dontAccount = findViewById(R.id.dontAccountId);

        String check = "";


    }

    @Override
    protected void onStart() {
        super.onStart();

        checkSession();
    }

    private void checkSession() {
        SessionManagement sessionManagement = new SessionManagement(LogInActivity.this);
        String  userEmail = sessionManagement.getSession();

        if(userEmail != ""){
            moveToMainActivity();
        }
        else{
            //do nothing
        }
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        User user = new User(MainActivity.this);
//
//        if (user.getEmail() != "") {
//
//        } else {
//
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            intent.putExtra("email", user.getEmail());
//            startActivity(intent);
//        }
//    }


    public void login(View view) {

        switch (view.getId()) {

            case R.id.loginButtonId:
                userLogin();
                break;

            case R.id.dontAccountId:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);

                break;
        }

    }

    private void userLogin() {
        String email = loginEmail.getText().toString().trim();
        String password = loginpassword.getText().toString().trim();

        if (email.isEmpty()) {
            loginEmail.setError("Please Enter a Valid Email");
            loginEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginEmail.setError("Please Enter a Valid Email");
            loginEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            loginpassword.setError("please Enter a Strong Password");
            loginpassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            loginpassword.setError("Password Should Be 6 Characters");
            loginpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    User user = new User(email,password);
                    SessionManagement sessionManagement = new SessionManagement(LogInActivity.this);
                    sessionManagement.saveSession(user);

                    finish();
                    moveToMainActivity();

                } else {
                    Toast.makeText(getApplicationContext(), "There Is a Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void moveToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}