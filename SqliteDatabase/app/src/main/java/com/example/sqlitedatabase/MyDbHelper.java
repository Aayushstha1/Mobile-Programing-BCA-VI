package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context) {
        super(context, "myDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Student(name varchar(50) primary key, phone varchar(20) not null)");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Student");
        onCreate(db);

    }
    public boolean insert(Student s) {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name", s.Name);
        values.put("phone", s.phone);
        db.insert("Student", null, values);
        db.close();
        return count>0;

    }
    public void update(Student s) {

    }
    public void removeStudent(Student s){

    }
    public ArrayList<Student> getStudents(){
        ArrayList<Student> list= new ArrayList<Student>();
        return list;
    }
}
