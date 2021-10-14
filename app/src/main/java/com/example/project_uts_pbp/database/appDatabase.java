package com.example.project_uts_pbp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room_a_0070.dao.profileDao;
import com.example.room_a_0070.model.user;

@Database(entities = {user.class }, version = 1)
public abstract class appDatabase extends RoomDatabase {
    public abstract profileDao profileDao();
}
