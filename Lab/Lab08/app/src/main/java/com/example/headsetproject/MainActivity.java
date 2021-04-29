package com.example.headsetproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private HeadPhoneReciever mReciever = new HeadPhoneReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(mReciever, intentFilter);
    }

    protected void onDestroy() {
        this.unregisterReceiver(mReciever);
        super.onDestroy();
    }
}