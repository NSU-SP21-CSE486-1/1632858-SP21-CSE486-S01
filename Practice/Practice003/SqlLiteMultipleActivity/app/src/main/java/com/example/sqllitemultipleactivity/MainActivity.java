package com.example.sqllitemultipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mName;
    EditText mAddress;

    public static final String EXTRA_Name = "com.example.sqllitemultipleactivity.EXTRA.name";
    public static final String EXTRA_Address = "com.example.sqllitemultipleactivity.EXTRA.address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name_edittext);
        mAddress = findViewById(R.id.address_edittext);
    }

    public void nextActivity(View view) {
        String name_pass = mName.getText().toString();
        String address_pass = mAddress.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_Name, name_pass);
        intent.putExtra(EXTRA_Address, address_pass);
        startActivity(intent);
    }

    public void viewAllStudents(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}