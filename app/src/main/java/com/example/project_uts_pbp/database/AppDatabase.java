package com.example.project_uts_pbp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project_uts_pbp.model.Pendaftaran;
import com.example.project_uts_pbp.dao.PendaftaranDao;

@Database(entities = {Pendaftaran.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PendaftaranDao pendaftaranDao();
}
