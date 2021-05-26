package com.sadmanahmed.nsucpcadmin.uicontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.sadmanahmed.nsucpcadmin.R;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //Set the action bar title
        getSupportActionBar().setTitle(R.string.change_password);

        //set the actionbar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E9D36B")));

        //set the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                Intent intent1 = new Intent(ChangePasswordActivity.this, MainActivity.class);
                startActivity(intent1);
                return true;

            case R.id.mainmenu_option2:
                Toast.makeText(this, "Add Jobs", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_option3:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_option4:
                Toast.makeText(this, "All Jobs", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mainmenu_option5:
//                Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(ChangePasswordActivity.this, ChangePasswordActivity.class);
                startActivity(intent5);
                return true;

            case R.id.mainmenu_option6:
                Intent intent6 = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}