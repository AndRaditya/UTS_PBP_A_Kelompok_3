package com.example.project_uts_pbp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project_uts_pbp.Model.Pendaftaran;
import com.example.project_uts_pbp.Dao.PendaftaranDao;

@Database(entities = {Pendaftaran.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PendaftaranDao pendaftaranDao();
}
