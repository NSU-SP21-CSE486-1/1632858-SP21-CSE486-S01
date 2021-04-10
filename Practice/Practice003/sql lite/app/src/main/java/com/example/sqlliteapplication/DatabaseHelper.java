package com.example.sqlliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "customer_table";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String CUSTOMER_AGE = "customer_age";
    public static final String ACTIVE_CUSTOMER = "active_customer";
    public static final String ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " TEXT, " + CUSTOMER_AGE + " INT, " + ACTIVE_CUSTOMER + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean addOne(CustomerModel customerModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CUSTOMER_NAME, customerModel.getName());
        cv.put(CUSTOMER_AGE, customerModel.getAge());
        cv.put(ACTIVE_CUSTOMER, customerModel.isActive());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);

        if(insert == -1){
            return false;
        }
        else{
            return true;
        }

    }
}
