package com.example.lovedeepsangha.quiz1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
public static  final String  DATABASE_NAME="Student.db";
    public static  final String  TABLE_NAME="Student_Table";
    public static  final String COL_1="ID";
    public static  final String COL_2="NAME";
    public static  final String COL_3="SURNAME";
    public static  final String COL_4="MARKS";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String surname,String marks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4, marks);
        long k=db.insert(TABLE_NAME,null,contentValues);
        if (k==-1)
            return false;
        else
            return  true;
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;

    }
}
