package com.example.shoppinglistextended;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemList extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.shoppinglistextened.extra.REPLY";

    private Button mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
//        mReply = findViewById(R.id.button);
//        mReply = findViewById(R.id.button2);
//        mReply = findViewById(R.id.button3);
//        mReply = findViewById(R.id.button4);
//        mReply = findViewById(R.id.button5);
//        mReply = findViewById(R.id.button6);
//        mReply = findViewById(R.id.button7);
//        mReply = findViewById(R.id.button8);
//        mReply = findViewById(R.id.button9);
//        mReply = findViewById(R.id.button10);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF4DB6AC"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }

    public void getItems(View view) {
        mReply = findViewById(R.id.button);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void getItems2(View view) {
        mReply = findViewById(R.id.button2);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems3(View view) {
        mReply = findViewById(R.id.button3);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems4(View view) {
        mReply = findViewById(R.id.button4);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems5(View view) {
        mReply = findViewById(R.id.button5);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems6(View view) {
        mReply = findViewById(R.id.button6);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems7(View view) {
        mReply = findViewById(R.id.button7);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems8(View view) {
        mReply = findViewById(R.id.button8);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems9(View view) {
        mReply = findViewById(R.id.button9);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    public void getItems10(View view) {
        mReply = findViewById(R.id.button10);
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}