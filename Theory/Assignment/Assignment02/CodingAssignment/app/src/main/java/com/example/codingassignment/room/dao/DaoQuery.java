package com.example.codingassignment.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.codingassignment.model.StudentModel;

import java.util.List;

@Dao
public interface DaoQuery {
    @Insert
    public void insert(StudentModel studentModel);

    @Query ("SELECT * FROM StudentModel")
    List<StudentModel> getAllStudents();
}
