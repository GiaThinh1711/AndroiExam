package com.example.androiexam.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;

@Entity(tableName = "employee")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String Name;
    @ColumnInfo(name = "destination")
    public String Destination;
    @ColumnInfo(name = "salary")
    public int Salary;
}
