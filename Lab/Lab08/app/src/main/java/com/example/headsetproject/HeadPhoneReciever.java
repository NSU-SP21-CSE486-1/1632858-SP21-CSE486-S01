package com.example.headsetproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.example.headsetproject.R.string.toast_message;

public class HeadPhoneReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null){
            Toast.makeText(context, toast_message, Toast.LENGTH_LONG).show();
        }
    }
}
