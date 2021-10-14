 package com.example.project_uts_pbp;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

public class databaseTodo {
    private Context context;
    private static databaseTodo databaseTodo;

    private appDatabase database;

    public databaseTodo(Context context){
        this.context = context;
        database = Room.databaseBuilder(context, appDatabase.class, "todo").allowMainThreadQueries().build();
    }

    public static synchronized databaseTodo getInstance(Context context){
        if (databaseTodo==null){
            databaseTodo = new databaseTodo(context);
        }
        return databaseTodo;
    }

    public appDatabase getDatabase(){
        return database;
    }
}