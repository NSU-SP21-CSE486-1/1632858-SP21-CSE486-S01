package com.sadmanahmed.nsucpcadmin.uicontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;

import com.sadmanahmed.nsucpcadmin.R;
import com.sadmanahmed.nsucpcadmin.session.SessionManagement;

public class SplashScreen extends AppCompatActivity {
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //set status bar color
        if(Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        //splashscreen show delay
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SessionManagement sessionManagement = new SessionManagement(SplashScreen.this);
                String userEmail = sessionManagement.getSession();

                if(userEmail != ""){
                    moveToMainActivity();
                }
                else{
                    moveToLoginActivity();
                }

            }
        },3000);
    }

    private void moveToLoginActivity() {
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }

    private void moveToMainActivity() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}