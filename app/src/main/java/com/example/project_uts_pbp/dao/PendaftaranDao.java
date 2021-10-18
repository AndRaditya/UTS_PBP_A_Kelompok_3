package com.example.project_uts_pbp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project_uts_pbp.model.Pendaftaran;

import java.util.List;

@Dao
public interface PendaftaranDao {
    @Query("SELECT * FROM pendaftaran")
    List<Pendaftaran> getAll();

    @Insert
    void insertTodo(Pendaftaran pendaftaran);

//    @Update
//    void updateTodo(Todo todo);
//
//    @Delete
//    void deleteTodo(Todo todo);

}