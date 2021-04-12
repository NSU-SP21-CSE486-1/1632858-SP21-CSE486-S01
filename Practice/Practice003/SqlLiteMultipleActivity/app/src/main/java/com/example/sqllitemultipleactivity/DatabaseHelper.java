package com.example.sqllitemultipleactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "Student_table";
    public static final String ID = "ID";
    public static final String STUDENT_NAME = "STUDENT_NAME";
    public static final String STUDENT_ADDRESS = "STUDENT_ADDRESS";
    public static final String GENDER = "GENDER";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String DATE_OF_BIRTH = "DATE_OF_BIRTH";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "practice.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + STUDENT_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " TEXT, " + STUDENT_ADDRESS + " TEXT, " + GENDER + " TEXT, " + PHONE_NUMBER + " INT, " + DATE_OF_BIRTH + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addStudent(StudentModel studentModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENT_NAME, studentModel.getName());
        contentValues.put(STUDENT_ADDRESS, studentModel.getAddress());
        contentValues.put(GENDER, studentModel.getGender());
        contentValues.put(PHONE_NUMBER, studentModel.getPhoneNumber());
        contentValues.put(DATE_OF_BIRTH, studentModel.getDate());

        long insert = db.insert(STUDENT_TABLE, null, contentValues);

        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public List<StudentModel> getAllNames(){
        List<StudentModel> returnList = new ArrayList<>();

        String getNameQueryString = "SELECT * FROM " + STUDENT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(getNameQueryString, null);

        if(cursor.moveToFirst()){
            do{
                String studentName = cursor.getString(2);
                StudentModel newStudent = new StudentModel(studentName);
                returnList.add(newStudent);
            }while(cursor.moveToNext());
        }
        else{}

        cursor.close();
        db.close();

        return returnList;
    }


}
