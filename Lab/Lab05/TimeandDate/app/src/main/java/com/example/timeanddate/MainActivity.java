package com.example.timeanddate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mDateShow;
    private TextView mTimeShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDateShow = findViewById(R.id.Date_textview);
        mTimeShow = findViewById(R.id.Time_TextView);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string +
                "/" + month_string + "/" + year_string);
        String finalDateMessage = ("Date : " + dateMessage);
        mDateShow.setText(finalDateMessage);
//        Toast.makeText(this, getString(R.string.date2) + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.timePicker));
    }
    public void processTimePickerResult(int hourOfDay, int minute) {
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + ":" + minute_string);
        String finalTimeMessage = ("Time : "+ timeMessage);

        mTimeShow.setText(finalTimeMessage);

//        Toast.makeText(this,getString(R.string.time2)
//                + timeMessage, Toast.LENGTH_SHORT).show();
    }
}