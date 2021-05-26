package com.sadmanahmed.nsucpcadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.R.layout.simple_list_item_1;

public class SecondJobPostActivity extends AppCompatActivity {
    //declaring necessary variables
    private AutoCompleteTextView uDepName;
    private AutoCompleteTextView uJobType;

    private String companyName;
    private String vacantPosition;
    private String location;
    private String employeeNeeded;
    private String deadline;
    private String isNameHidden;

    private EditText uRecruiterEmail;
    private EditText uMinSalary;
    private EditText uMaxSalary;
    private Switch isSalaryNegotiable;

    DatabaseReference mDatabaseReference;
    FirebaseDatabase database;

    StorageReference storageReference;
    DatabaseReference databaseReference;

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

        //setting where to get the value from
        uRecruiterEmail = findViewById(R.id.recruiterEmail_edittext);
        uMinSalary = findViewById(R.id.salaryMinRange_edittext);
        uMaxSalary = findViewById(R.id.salaryMaxRange_edittext);
        isSalaryNegotiable = findViewById(R.id.isSalaryNegotiable);

        //get data from the previous activity
        Intent intent = getIntent();
        companyName = intent.getStringExtra(FirstJobPostActivity.COMPANY_NAME);
        isNameHidden = intent.getStringExtra(FirstJobPostActivity.ISNAMEHIDDEN);
        vacantPosition = intent.getStringExtra(FirstJobPostActivity.VACANT_POSITION);
        location = intent.getStringExtra(FirstJobPostActivity.LOCATION);
        employeeNeeded = intent.getStringExtra(FirstJobPostActivity.NUMBER_OF_EMPLOYEE);
        deadline = intent.getStringExtra(FirstJobPostActivity.DEADLINE);

        database = FirebaseDatabase.getInstance();
        mDatabaseReference = database.getReference("JobModel");

        storageReference = FirebaseStorage.getInstance().getReference();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("JobModel");
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
                FirebaseAuth.getInstance().signOut();
                SessionManagement sessionManagement = new SessionManagement(SecondJobPostActivity.this);
                sessionManagement.removeSession();
                Intent intent6 = new Intent(SecondJobPostActivity.this, LoginActivity.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onPostBtnClick(View view) {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Choose A Pdf File"), 12);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12 && resultCode == RESULT_OK && data !=null && data.getData() !=null){
            uploadPdfFile(data.getData());
        }
    }

    private void uploadPdfFile(Uri data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading Pdf File");
        progressDialog.show();

        StorageReference refr =  storageReference.child("uploadPDF: "+System.currentTimeMillis()+".pdf");
        refr.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while ((!uriTask.isComplete()));
                        Uri uri = uriTask.getResult();

                        //getting the rest of the data
                        String depName = uDepName.getText().toString();
                        String jobType = uJobType.getText().toString();
                        String recruiterEmail = uRecruiterEmail.getText().toString();
                        String minSalary = uMinSalary.getText().toString();
                        String maxSalary = uMaxSalary.getText().toString();
                        String salaryNegotiability = String.valueOf(isSalaryNegotiable.isChecked());

                        if(salaryNegotiability == "true"){
                            minSalary = "0";
                            maxSalary = "0";
                        }

                        String uKey = mDatabaseReference.push().getKey();

                        JobModel jobModel = new JobModel(companyName, isNameHidden,vacantPosition,location,
                                Integer.parseInt(employeeNeeded),deadline, depName,jobType,recruiterEmail,
                                Integer.parseInt(minSalary),Integer.parseInt(maxSalary),salaryNegotiability,"test",uri.toString());
                        mDatabaseReference.child(uKey).push().setValue(jobModel);

                        Toast.makeText(getApplicationContext(), "Data Upload Successfully", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Intent intent = new Intent(SecondJobPostActivity.this,SuccessfullPostActivity.class);
                        startActivity(intent);
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull @NotNull UploadTask.TaskSnapshot snapshot) {

            }
        });
    }

}