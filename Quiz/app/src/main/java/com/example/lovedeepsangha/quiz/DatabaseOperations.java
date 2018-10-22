package com.example.lovedeepsangha.quiz;

/**
 * Created by Lovedeep sangha on 10-04-2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
    public  static final int database_version=1;
    public  static final String CREATE_QUERY="CREATE TABLE"+ Table_data.Table_info.Table_Name+"("+ Table_data.Table_info.User_name+" TEXT);";
    public DatabaseOperations(Context context){
        super(context, Table_data.Table_info.Database_Name,null,database_version);
        Log.d("Database OPeration","database created");
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);Log.d("database operation","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(DatabaseOperations dop,String name){
        SQLiteDatabase sq=dop.getWritableDatabase();
        ContentValues cv=new ContentValues();cv.put(Table_data.Table_info.User_name,name);
        long k=  sq.insert(Table_data.Table_info.Table_Name,null,cv);
        Log.d("Database opertaion","putting values");
    }
}
