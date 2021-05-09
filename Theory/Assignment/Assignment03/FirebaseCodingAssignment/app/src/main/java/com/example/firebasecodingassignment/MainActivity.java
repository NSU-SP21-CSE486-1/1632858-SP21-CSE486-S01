package com.example.firebasecodingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView mShowUser;
    FirebaseAuth uAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uAuth = FirebaseAuth.getInstance();

        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        mShowUser = findViewById(R.id.show_name_textview);
        mShowUser.setText(String.valueOf(sessionManagement.getSession()));
    }

    public void onLogoutClick(View view) {
        FirebaseAuth.getInstance().signOut();
        SessionManagement sessionManagement = new SessionManagement(MainActivity.this);
        sessionManagement.removeSession();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//        finish();
    }

    public void onViewAllClick(View view) {
        Intent intent = new Intent(MainActivity.this, ViewAll.class);
        startActivity(intent);

    }
}