package com.dataflair.reminderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManager extends SQLiteOpenHelper {
    private static String dbname = "reminder";                                                      //Table  name to store reminders in sqllite

    public dbManager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {                                           //sql query to insert data in sqllite
        String query = "create table tbl_reminder(id integer primary key autoincrement,title text,date text,time text,type text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS tbl_reminder";                                         //sql query to check table with the same name or not
        sqLiteDatabase.execSQL(query);                                                              //executes the sql command
        onCreate(sqLiteDatabase);

    }

    public String addreminder(String title, String date, String time,String type) {
        SQLiteDatabase database = this.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);                                                          //Inserts  data into sqllite database
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("type",type);

        float result = database.insert("tbl_reminder", null, contentValues);    //returns -1 if data successfully inserts into database

        if (result == -1) {
            return "Failed";
        } else {
            return "Successfully inserted";
        }

    }

    public Cursor readallreminders() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select * from tbl_reminder order by id desc";                               //Sql query to  retrieve  data from the database
        //String query="select * from "+dbname+" WHERE type='Education'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }

    public Cursor readEducation() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Education'";                               //Sql query to  retrieve  data from the database
        //String query="select * from "+dbname+" WHERE type='Education'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }
    public Cursor readFinance() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Finance'";                               //Sql query to  retrieve  data from the database
        //String query="select * from "+dbname+" WHERE type='Education'";
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }
    public Cursor readHealth(){
        SQLiteDatabase database=this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Health'";
        Cursor cursor=database.rawQuery(query,null);
        return  cursor;
    }

    public Cursor readDaily(){
        SQLiteDatabase database=this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Daily'";
        Cursor cursor=database.rawQuery(query,null);
        return  cursor;
    }

    public Cursor readEvent(){
        SQLiteDatabase database=this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Event'";
        Cursor cursor=database.rawQuery(query,null);
        return  cursor;
    }

    public Cursor readOthers(){
        SQLiteDatabase database=this.getWritableDatabase();
        String query = "select * from tbl_reminder where type='Others'";
        Cursor cursor=database.rawQuery(query,null);
        return  cursor;
    }
}
