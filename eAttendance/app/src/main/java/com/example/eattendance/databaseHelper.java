package com.example.eattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {
    public static final String database_name ="studentrecord.db";
    public static final String studenttable ="studenttable";
    public static final String roll_no ="roll_no";
    public static final String name ="name";
    public static final String mobile_no ="mobile_no";
    public static final String status ="status";

    public databaseHelper(Context context) {
        super(context, database_name, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_studenttable = "CREATE TABLE " + studenttable + "("
                + roll_no + " INTEGER PRIMARY KEY," + name + " TEXT,"
                + mobile_no + " TEXT," + status + ", TEXT" + ")";
        sqLiteDatabase.execSQL(create_studenttable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+studenttable);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,int roll_no,String mobile_no,String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.roll_no,roll_no);
        contentValues.put(this.name,name);
        contentValues.put(this.mobile_no,mobile_no);
        contentValues.put(this.status,status);
        long result = db.insert(studenttable,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studenttable,null);
        return res;
    }

}

