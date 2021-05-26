package com.sadmanahmed.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //splashscreen show delay
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
//                SessionManagement sessionManagement = new SessionManagement(SplashScreen.this);
//                String userEmail = sessionManagement.getSession();
//
//                if(userEmail != ""){
//                    moveToMainActivity();
//                }
//                else{
//                    moveToLoginActivity();
//                }
                moveToMainActivity();

            }
        },3000);
    }

    private void moveToMainActivity() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }

    private void moveToLoginActivity() {
    }
}