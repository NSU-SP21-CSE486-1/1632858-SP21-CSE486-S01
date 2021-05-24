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
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FirstJobPostActivity extends AppCompatActivity {
    //declaring necessary variables
    private EditText uCompanyName;
    private EditText uVacantPosition;
    private EditText uLocation;
    private EditText uNumberOfEmployee;
    private EditText uDeadline;
    private Switch isNameHidden;

    //setting the varibales to pass the values through intent
    public static final String COMPANY_NAME = "com.sadmanahmed.nsucpcadmin.extra.COMPANYNAME";
    public static final String VACANT_POSITION = "com.sadmanahmed.nsucpcadmin.extra.VACANTPOSITION";
    public static final String LOCATION = "com.sadmanahmed.nsucpcadmin.extra.LOCATION";
    public static final String NUMBER_OF_EMPLOYEE = "com.sadmanahmed.nsucpcadmin.extra.NUMEROFEMPLOYEE";
    public static final String DEADLINE = "com.sadmanahmed.nsucpcadmin.extra.DEADLINE";
    public static final String ISNAMEHIDDEN = "com.sadmanahmed.nsucpcadmin.extra.ISNAMEHIDDEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_job_post);

        //Set the action bar title
        getSupportActionBar().setTitle(R.string.job_post);

        //set the actionbar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E9D36B")));

        //set the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setting where to take the value
        uCompanyName = findViewById(R.id.companyName_edittext);
        uVacantPosition = findViewById(R.id.vacantPosition_edittext);
        uLocation = findViewById(R.id.location_edittext);
        uNumberOfEmployee = findViewById(R.id.employeeNeeded_edittext);
        uDeadline = findViewById(R.id.deadline_edittext);
        isNameHidden = findViewById(R.id.isHiddenCompanyName);

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
                Intent intent1 = new Intent(FirstJobPostActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;

            case R.id.mainmenu_option2:
//                Toast.makeText(this, "Add Jobs", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(FirstJobPostActivity.this, FirstJobPostActivity.class);
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
                Intent intent5 = new Intent(FirstJobPostActivity.this, ChangePasswordActivity.class);
                startActivity(intent5);
                return true;

            case R.id.mainmenu_option6:
                FirebaseAuth.getInstance().signOut();
                SessionManagement sessionManagement = new SessionManagement(FirstJobPostActivity.this);
                sessionManagement.removeSession();
                Intent intent6 = new Intent(FirstJobPostActivity.this, LoginActivity.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onNextBtnClick(View view) {
//        Toast.makeText(this, "works", Toast.LENGTH_SHORT).show();
        boolean allowTONext = true;
        //getting data
        String companyName = uCompanyName.getText().toString();
        String vacantPosition = uVacantPosition.getText().toString();
        String location = uLocation.getText().toString();
        String employeeNeeded = uNumberOfEmployee.getText().toString();
        String deadline = uDeadline.getText().toString();
        Boolean isCompanyNameHidden = isNameHidden.isChecked();

        //setting up the validation
        if(companyName.length() == 0){
            uCompanyName.setError("Company name cannot be empty");
            allowTONext = false;
        }

        if(vacantPosition.length() == 0){
            uVacantPosition.setError("You should mention the vacant position");
            allowTONext = false;
        }

        //passing data from one activity to another
        if(allowTONext){
            Intent intent = new Intent(FirstJobPostActivity.this, SecondJobPostActivity.class);

            intent.putExtra(COMPANY_NAME, companyName);
            intent.putExtra(VACANT_POSITION, vacantPosition);
            intent.putExtra(LOCATION, location);
            intent.putExtra(NUMBER_OF_EMPLOYEE, employeeNeeded);
            intent.putExtra(DEADLINE, deadline);
            intent.putExtra(String.valueOf(ISNAMEHIDDEN), isCompanyNameHidden);

            startActivity(intent);

        }

    }
}