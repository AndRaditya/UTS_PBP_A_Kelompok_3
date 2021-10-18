package com.example.project_uts_pbp.database;

import android.content.Context;
import androidx.room.Room;

public class DatabasePendaftaran {
    private Context context;
    private static DatabasePendaftaran databasePendaftaran;

    private AppDatabase database;

    public DatabasePendaftaran(Context context){
        this.context = context;
        database = Room.databaseBuilder(context, AppDatabase.class, "pendaftaran").allowMainThreadQueries().build();
    }

    public static synchronized DatabasePendaftaran getInstance(Context context){
        if (databasePendaftaran==null){
            databasePendaftaran = new DatabasePendaftaran(context);
        }
        return databasePendaftaran;
    }

    public AppDatabase getDatabase(){
        return database;
    }
}