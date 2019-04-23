package com.example.sqlactivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLClass extends SQLiteOpenHelper{

    public SQLClass(Context context) {
        super(context,"studentrecords.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(stprn int primary key,stclass text,stdiv text,styear int,stname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }

    public Cursor getByPercentage(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor csp= db.rawQuery("select * from student order by styear desc",null);
        return csp;
    }

    public Cursor getByCategory(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor csc= db.rawQuery("select * from student where stname like 's'",null);
        return csc;
    }
}
