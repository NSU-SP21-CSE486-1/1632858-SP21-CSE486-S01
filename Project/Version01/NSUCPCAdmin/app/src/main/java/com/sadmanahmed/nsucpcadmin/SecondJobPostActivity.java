package com.sadmanahmed.nsucpcadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class SecondJobPostActivity extends AppCompatActivity {
    //declaring necessary variables
    private AutoCompleteTextView uDepName;
    private AutoCompleteTextView uJobType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_job_post);

        //Set the action bar title
        getSupportActionBar().setTitle(R.string.job_post);

        //set the actionbar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E9D36B")));

        //set the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set the department name dropdown
        uDepName = findViewById(R.id.departmentName_dropdown);

        String[] depNameList = getResources().getStringArray(R.array.nsu_dep_list);
        ArrayAdapter depNameAdapter= new ArrayAdapter(this, simple_list_item_1, depNameList);

        uDepName.setAdapter(depNameAdapter);

        //set the job type dropdown
        uJobType = findViewById(R.id.jobType_dropdown);

        String[] jobTypeList = getResources().getStringArray(R.array.job_types);
        ArrayAdapter jobTypeAdapter = new ArrayAdapter(this, simple_list_item_1, jobTypeList);

        uJobType.setAdapter(jobTypeAdapter);

    }

    //Set the options menu on the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainscreen_menu, menu);
        return true;
    }

    //choose the onclick for the option menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mainmenu_option1:
//                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(SecondJobPostActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;

            case R.id.mainmenu_option2:
//                Toast.makeText(this, "Add Jobs", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(SecondJobPostActivity.this, FirstJobPostActivity.class);
                startActivity(intent2);
                return true;

            case R.id.mainmenu_option3:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_option4:
                Toast.makeText(this, "All Jobs", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_option5:
//                Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(SecondJobPostActivity.this, ChangePasswordActivity.class);
                startActivity(intent5);
                return true;

            case R.id.mainmenu_option6:
                Intent intent6 = new Intent(SecondJobPostActivity.this, LoginActivity.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onPostBtnClick(View view) {
        Toast.makeText(this, "Works!!!!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SecondJobPostActivity.this,SuccessfullPostActivity.class);
        startActivity(intent);
    }
}