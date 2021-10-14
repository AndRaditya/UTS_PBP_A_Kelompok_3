package com.example.project_uts_pbp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project_uts_pbp.model.user;

import java.util.List;

@Dao
public interface ProfileDao {
    @Query("SELECT * FROM todo")
    List<user> getAll();

    @Insert
    void insertTodo(Todo todo);

    @Update
    void updateTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);

}