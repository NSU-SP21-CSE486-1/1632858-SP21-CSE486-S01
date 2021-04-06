package com.example.codingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mid = findViewById(R.id.nsu_id);
    }

    public void clicknext(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
//        String id = mid.getText().toString();
//        if(id.length() == 7) {
//            Intent intent = new Intent(this,SecondActivity.class);
//            startActivity(intent);
//        }
//        else{
//            mid.setError("This is not your nsu id");
//        }
    }
}