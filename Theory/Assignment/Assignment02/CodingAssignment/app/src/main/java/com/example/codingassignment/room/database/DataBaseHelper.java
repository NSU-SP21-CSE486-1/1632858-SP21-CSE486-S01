package com.example.codingassignment.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.codingassignment.model.StudentModel;
import com.example.codingassignment.room.dao.DaoQuery;

@Database(entities = {StudentModel.class},version = 1, exportSchema = false)
public abstract class DataBaseHelper extends RoomDatabase {
    public abstract DaoQuery daoQuery();
}
