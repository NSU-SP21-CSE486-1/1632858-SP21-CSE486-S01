package com.example.codingassignment;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoQuery {
    @Insert
    public void insert(StudentModel studentModel);

    @Query ("SELECT * FROM StudentModel")
    List<StudentModel> getAllStudents();
}
