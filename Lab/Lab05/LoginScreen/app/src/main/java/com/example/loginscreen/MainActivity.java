package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailEditText = findViewById(R.id.Email_edittext);
        mPasswordEditText = findViewById(R.id.Password_edittext);
    }

    public void checkValidation(View view) {
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        if(email.equals("sadman@gmail.com") && password.equals("12345")){
            Intent intent = new Intent(this,SuccessScreen.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}