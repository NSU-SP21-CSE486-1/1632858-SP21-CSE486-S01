package com.example.shoppinglist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyTextView;
    private TextView[] txt;
    private int i = 0;

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("reply_text",mReplyTextView.getText().toString());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF4DB6AC"));
        actionBar.setBackgroundDrawable(colorDrawable);
//        if (savedInstanceState != null) {
//            boolean isVisible =
//                    savedInstanceState.getBoolean("reply_visible");
//            if (isVisible) {
//
//                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
//                mReplyTextView.setVisibility(View.VISIBLE);
//            }
//        }


    }

    public void getItemNames(View view) {
        Intent intent = new Intent(this,ItemList.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {

        if(i == 0){
            mReplyTextView = findViewById(R.id.item1);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }

        }
        else if(i == 1){
            mReplyTextView = findViewById(R.id.item2);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 2){
            mReplyTextView = findViewById(R.id.item3);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 3){
            mReplyTextView = findViewById(R.id.item4);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 4){
            mReplyTextView = findViewById(R.id.item5);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 5){
            mReplyTextView = findViewById(R.id.item6);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 6){
            mReplyTextView = findViewById(R.id.item7);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 7){
            mReplyTextView = findViewById(R.id.item8);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 8){
            mReplyTextView = findViewById(R.id.item9);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        else if(i == 9){
            mReplyTextView = findViewById(R.id.item10);
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(ItemList.EXTRA_REPLY);
                    mReplyTextView.setText(reply);
                    mReplyTextView.setVisibility(View.VISIBLE);
                }
            }
        }
        i++;
    }

}