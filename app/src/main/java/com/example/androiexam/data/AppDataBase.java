package com.example.androiexam.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDatabase;

    public abstract EmployeeDao employeeDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDataBase.class, "employee.db").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
