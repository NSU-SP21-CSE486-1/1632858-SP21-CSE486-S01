package com.example.codingassignment;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

import java.io.DataOutput;

@Database(entities = {StudentModel.class},version = 1, exportSchema = false)
public abstract class DataBaseHelper extends RoomDatabase {
    public abstract DaoQuery daoQuery();
}
