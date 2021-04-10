package com.example.sqlliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    Button btn_view;
    EditText mName;
    EditText mAge;
    Switch mActive;
    ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name_edittext);
        mAge = findViewById(R.id.age_edittext);
        btn_add = findViewById(R.id.add_button);
        mActive = findViewById(R.id.active_switch);
        btn_view = findViewById(R.id.viewall_button);
        mListview = findViewById(R.id.Listview);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerModel customerModel;
                try{
                     customerModel = new CustomerModel(-1, mName.getText().toString(), Integer.parseInt(mAge.getText().toString()),mActive.isChecked());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    customerModel = new CustomerModel(-1,"error",0,false);
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(customerModel);

                Toast.makeText(MainActivity.this, "Success = "+ success, Toast.LENGTH_SHORT).show();
//               Toast.makeText(MainActivity.this, "Add button", Toast.LENGTH_SHORT).show();

            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "View Button", Toast.LENGTH_SHORT).show();
            }
        });
    }


}